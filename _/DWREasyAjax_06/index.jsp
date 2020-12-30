<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="styles.css" rel="stylesheet" type="text/css"/>
<script type='text/javascript' src='js/popup.js'></script>
<script type='text/javascript' src='/DWREasyAjax/dwr/engine.js'></script>
<script type='text/javascript' src='/DWREasyAjax/dwr/util.js'></script>
<script type='text/javascript' src='/DWREasyAjax/dwr/interface/HorizontalMenu.js'></script>
<script type='text/javascript' src='/DWREasyAjax/dwr/interface/CountryDB.js'></script>
<script type='text/javascript' src='/DWREasyAjax/dwr/interface/AppContent.js'></script>
<script type='text/javascript' src='/DWREasyAjax/dwr/interface/LicenseDB.js'></script>
<script type='text/javascript' src='/DWREasyAjax/dwr/interface/FormHandler.js'></script>
<script type='text/javascript' src='/DWREasyAjax/dwr/interface/NavigationTree.js'></script>
<title>DWR samples</title>
<script type="text/javascript">

function loadMenuItems()
{
  dwr.engine.setActiveReverseAjax(true);
  HorizontalMenu.getMenuItems(setMenuItems);
}

function getContent(contentId)
{
  AppContent.getContent(contentId,setContent);
}

function menuItemFormatter(item)
{
  elements=item.split(',');
  return '<li><a href="#" onclick="getContent(\''+elements[1]+'\');return false;">'+elements[0]+'</a></li>';
}

function setMenuItems(menuItems)
{
  menu=dwr.util.byId("dwrMenu");
  menuItemsHtml='';
  for(var i=0;i<menuItems.length;i++)
  {
    menuItemsHtml=menuItemsHtml+menuItemFormatter(menuItems[i]);
  }
  menu.innerHTML=menuItemsHtml;
}

function setContent(htmlArray)
{
  var contentFunctions='';
  var scriptToBeEvaled='';
  var contentHtml='';
  for(var i=0;i<htmlArray.length;i++)
  {
    var html=htmlArray[i];
    if(html.toLowerCase().indexOf('<script')>-1)
    {
      if(html.indexOf('TO BE EVALED')>-1)
      {
        scriptToBeEvaled=html.substring(html.indexOf('>')+1,html.indexOf('</'));
      }
      else
      {
        eval(html.substring(html.indexOf('>')+1,html.indexOf('</')));
        contentFunctions+=html;
      }
    }
    else
    {
      contentHtml+=html;
    }
  }

  contentScriptArea=dwr.util.byId("contentAreaFunctions");
  contentScriptArea.innerHTML=contentFunctions;
  contentArea=dwr.util.byId("contentArea");
  contentArea.innerHTML=contentHtml;
  if(scriptToBeEvaled!='')
  {
    eval(scriptToBeEvaled);
  }
}

//start Tables and lists functions
function selectLetter(selectElement)
{
  var selectedIndex = selectElement.selectedIndex; 
  var selectedLetter= selectElement.options[selectedIndex ].value; 
  CountryDB.getCountries(selectedLetter,setCountryRows);
  //get countries starting with letter
}

function addLetters(letters)
{
dwr.util.addOptions('letters',['letter...']);
dwr.util.addOptions('letters',letters);
}

function setCountryRows(countryData)
{
var cellFuncs = [
  function(data) { return data[0]; },
  function(data) { return data[1]; },
  function(data) { return data[2]; },
  function(data) { return data[3]; },
  function(data) { return data[4]; }
];
dwr.util.removeAllRows('countryData');
dwr.util.addRows( 'countryData',countryData,cellFuncs, {

  cellCreator:function(options) {
    var td = document.createElement("td");
    if(options.cellNum==4)
    {
      var notes=options.rowData[4];
      if(notes==undefined)
      {
        notes='&nbsp;';// + options.rowData[2]+'notes';
      }
      //notes='';
      //td.onDblClick="javascript:test('jee jee')";
      var ccode=options.rowData[2];
      var divId=ccode+'_Notes';
      var tdId=divId+'Cell';
      td.setAttribute('id',tdId);
      var html=getNotesHtml(ccode,notes);
      td.innerHTML=html;
      options.data=html;
    }
    return td;
  },
  escapeHtml:false
 });
}

function getNotesHtml(ccode,notes)
{
  var divId=ccode+'_Notes';
  return "<div onDblClick=\"editCountryNotes('"+divId+"','"+ccode+"');\" id=\""+divId+"\">"+notes+"</div>";
}

function editCountryNotes(id,ccode)
{
  var notesElement=dwr.util.byId(id);
  var tdId=id+'Cell';
  var notes=notesElement.innerHTML;
  if(notes=='&nbsp;')
  {
    notes='';
  }
  var editBox='<input id="'+ccode+'NotesEditBox" type="text" value="'+notes+'"/><br/>';
  editBox+="<input type='button' id='"+ccode+"SaveNotesButton' value='Save' onclick='saveCountryNotes(\""+ccode+"\");'/>";
  editBox+="<input type='button' id='"+ccode+"CancelNotesButton' value='Cancel' onclick='cancelEditNotes(\""+ccode+"\");'/>";
  tdElement=dwr.util.byId(tdId);
  tdElement.innerHTML=editBox;
  dwr.util.byId(ccode+'NotesEditBox').focus();
}

function cancelEditNotes(ccode)
{
  var countryData=CountryDB.getCountryData(ccode, {
  callback:function(data) 
  { 
    var notes=data[4];
    if(notes==undefined)
    {
      notes='&nbsp;';
    }
    var html=getNotesHtml(ccode,notes);
    var tdId=ccode+'_NotesCell';
    var td=dwr.util.byId(tdId);
    td.innerHTML=html;
  }
  });

}

function saveCountryNotes(ccode)
{
  var editBox=dwr.util.byId(ccode+'NotesEditBox');
  var newNotes=editBox.value;
  CountryDB.saveCountryNotes(ccode,newNotes, {
  callback:function(newNotes) 
  { 
    var ccode=newNotes[0];
    var notes=newNotes[1];
    var notesHtml=getNotesHtml(ccode,notes);
    var td=dwr.util.byId(ccode+"_NotesCell");
    td.innerHTML=notesHtml;
  }
  });
}

//end Tables and lists functions

//start Field completion functions
function showPopupMenu()
{
  var licenseNameEditBox=dwr.util.byId('licenseNameEditBox');
  var startLetters=licenseNameEditBox.value;
  LicenseDB.getLicensesStartingWith(startLetters, {
  callback:function(licenses) 
  { 
    
    var html="";
    if(licenses.length==0)
    {
      return;
    }
    if(licenses.length==1)
    {
      hidePopupMenu();
      licenseNameEditBox.value=licenses[0];
    }
    else
    {
      for (index in licenses)
      {
        var licenseName=licenses[index];//.split(",")[0];
        licenseName=licenseName.replace(/\"/g,"&quot;");
        html+="<div style=\"border:1px solid #777777;margin-bottom:5;\" onclick=\"completeEditBox('"+licenseName+"');\">"+licenseName+"</div>";
      }
      show_box(html, 200, 270, '1px solid','completionMenuPopup');
    } 
  }
  });
}

function hidePopupMenu()
{
  hide_box('completionMenuPopup');
}

function completeEditBox(licenseName)
{
  var licenseNameEditBox=dwr.util.byId('licenseNameEditBox');
  licenseNameEditBox.value=licenseName;
  hidePopupMenu();
  dwr.util.byId('showLicenseTextButton').focus();
}

function showLicenseText()
{
  var licenseNameEditBox=dwr.util.byId('licenseNameEditBox');
  licenseName=licenseNameEditBox.value;
  console.log(licenseName);
  LicenseDB.getLicenseContentUrl(licenseName,{
  callback:function(licenseUrl) 
  { 
    var html='<iframe src="'+licenseUrl+'" width="100%" height="600"></iframe>';
    var content=dwr.util.byId('licenseContent');
    content.style.zIndex="1";
    content.innerHTML=html;
  }
  });
}
//end Field completion functions
//start Form handler functions

function useTestCreditCardNumber()
{
  var creditCardEditBox=dwr.util.byId('creditCardEditBox');
  creditCardEditBox.value='5555555555554444';
}

function isValidCreditCard()
{
  var creditCardEditBox=dwr.util.byId('creditCardEditBox');
  creditCardNumber=creditCardEditBox.value;
  FormHandler.isValidCreditCard(creditCardNumber,{
  callback:function(valid) 
  { 
    var feedback=dwr.util.byId('formFeedback');
    var html="";
    if(!valid)
    {
      html='<p><font color="red">Credit card number is not valid.</font></p>';
    }
    feedback.innerHTML=html;
  }
  });
} 

function checkExpiryDate()
{
  var expiryEditBox=dwr.util.byId('expiryEditBox');
  expiryDate=expiryEditBox.value;
  FormHandler.checkExpiryFormat(expiryDate,{
  callback:function(valid) 
  { 
    var feedback=dwr.util.byId('formFeedback');
    var html="";
    if(!valid)
    {
      html='<p><font color="red">Expiry date is not in correct format.</font></p>';
    }
    feedback.innerHTML=html;
  }
  });
} 

function submitOrder()
{
  var creditCardEditBox=dwr.util.byId('creditCardEditBox');
  creditCardNumber=creditCardEditBox.value;
  var expiryEditBox=dwr.util.byId('expiryEditBox');
  expiryDate=expiryEditBox.value;
  var nameEditBox=dwr.util.byId('nameEditBox');
  name=nameEditBox.value;
  var addressEditBox=dwr.util.byId('addressEditBox');
  address=addressEditBox.value;

  FormHandler.submitOrder(name,address,creditCardNumber,expiryDate,{
  callback:function(orderSubmitted) 
  { 
    var feedback=dwr.util.byId('formFeedback');
    var html="";
    if(orderSubmitted)
    {
      html='<p><font color="green">Order submitted.</font></p>';
    }
    else
    {
      html='<p><font color="red">Order submit failed.</font></p>';
    
    }
    feedback.innerHTML=html;
  }
  });
}
//end Form handler functions

//start MavigationTree functions
function createTreeMenu(rootElements)
{
  var treeMenu=dwr.util.byId('treeMenu');
  var html="<ul>";
  
  for (index in rootElements)
  {
    var element=rootElements[index];
    NavigationTree.hasChildren(element,{
      async:false,
      callback:function(hasChildren) 
      { 
        if(hasChildren)
        {
          html+='<li><a href="#" onclick="expandElement(this);return false;"> + '+element+'</a></li>';
        }
        else
        {
          html+='<li><a href="#" onclick="expandElement(this);return false;">'+element+'</a></li>';
        }
      }
      });
  }
  
  html+="</ul>";
  treeMenu.innerHTML=html;

}


function expandElement(element)
{
  var value=element.text.replace(' + ','');
  var html="";
  NavigationTree.getChildren(value,{
  async:false,
  callback:function(childElements) 
  { 
    for (index in childElements)
    {
      var element=childElements[index];
      NavigationTree.hasChildren(element,{
      async:false,
      callback:function(hasChildren) 
      { 
        if(hasChildren)
        {
          html+='<li><a href="#" onclick="expandElement(this);return false;"> + '+element+'</a></li>';
        }
        else
        {
          html+='<li style="background-color:#dddddd"><a href="#" onclick="showContent(this);return false;">'+element+'</a></li>';
        }
      }
      });    
    }
  }
  });
  var parentNode=element.parentNode;
  var childNodes=parentNode.childNodes;
  if(childNodes.length>1)
  {
    for(var i=1;i<childNodes.length;i++)
    {
      parentNode.removeChild(childNodes[i]);
    }
    var treeMenuContent=dwr.util.byId('treeMenuContent');
    treeMenuContent.innerHTML="";
  }
  else
  {
    var ul = document.createElement("ul");
    ul.innerHTML=html;
    ul.style.backgroundColor="#eeeeee";
    parentNode.appendChild(ul);
  }
}

function showContent(element)
{
  var value=element.text.replace(' ','');
  NavigationTree.getContent(value,{
  callback:function(content) 
  { 
    var treeMenuContent=dwr.util.byId('treeMenuContent');
    treeMenuContent.innerHTML=content;
  }
  });
}
//end MavigationTree functions

//start MapScrolling functions

function setZoomLevel(element)
{
  var selectedIndex = element.selectedIndex; 
  var value= element.options[selectedIndex].value; 
  var frames=window.frames;
  frames[0].setZoomLevel(value);
}

//end MapScrolling functions
function orderProcessed(orderConfirmationMessage)
{
    var feedback=dwr.util.byId('formFeedback');
    var html="";
    html=orderConfirmationMessage;
    feedback.innerHTML=html;
}
</script>
</head>
<body onload="loadMenuItems()">
<h1>DWR Easy Java Ajax Applications</h1>
<ul class="basictab" id="dwrMenu">
</ul>
<div id="contentAreaFunctions">
</div>
<div id="contentArea">
</div>
</body>
</html>