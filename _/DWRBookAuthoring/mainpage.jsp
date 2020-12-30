<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Book Authoring</title>
<link href="styles.css" rel="stylesheet" type="text/css" />
<%
	if (session.getAttribute("username") == null
			|| session.getAttribute("username").equals("")) {
		//if not logged in and trying to access this page
		//do nothing, browser shows empty page
		return;
	}
%>
<script type='text/javascript'
  src='/DWRBookAuthoring/dwr/interface/Login.js'></script>
<script type='text/javascript'
  src='/DWRBookAuthoring/dwr/interface/BookDatabase.js'></script>
<script type='text/javascript'
  src='/DWRBookAuthoring/dwr/engine.js'></script>
<script type='text/javascript' src='/DWRBookAuthoring/dwr/util.js'></script>
<script type="text/javascript">
dwr.engine.setActiveReverseAjax(true);

function logout()
{
  Login.doLogout(showLoginScreen);
}

function showLoginScreen()
{
  window.location.href='index.jsp';
}

function showUsersOnline()
{
  var cellFuncs = [
          function(author) {
 
            return '<i>'+author+'</i>';
          }
          ];
    Login.getUsersOnline({
    callback:function(authors) 
    {
      dwr.util.removeAllRows('authorsOnline');
      dwr.util.addRows( "authorsOnline",authors, cellFuncs, { escapeHtml:false });
    }
    });
}

function getBookLists()
{
  var cellFuncs = [
          function(title) {
 
            return '<a href="#" onclick="getChapters(this);">'+title+'</a>';
          }
          ];
    BookDatabase.getBooksInProgressTitles({
    callback:function(titles) 
    {
      dwr.util.removeAllRows('booksInProgress');
      dwr.util.addRows( "booksInProgress",titles , cellFuncs, { escapeHtml:false });
    }
    });
    
    var cellFuncs2 = [
          function(title) {
 
            return '<a href="#" onclick="showBook(this);">'+title+'</a>';
          }
          ];
    BookDatabase.getPublishedBookTitles({
    callback:function(titles) 
    {
      dwr.util.removeAllRows('publishedBooks');
      dwr.util.addRows( "publishedBooks",titles , cellFuncs2, { escapeHtml:false });
    }
    });
}

function getChapters(element)
{
  var bookTitle=element.firstChild.nodeValue;
  getChaptersForTitle(bookTitle);
}

function showBook(element)
{
  var bookTitle=element.firstChild.nodeValue;
  BookDatabase.getRenderedBook(bookTitle,{
          callback:function(bookContent) 
          { 
            clearContentAreas();
            //title area is used to show published book
            var contentArea=dwr.util.byId('bookTitleContentArea');
            contentArea.innerHTML=bookContent;
          }
        });
}

function getChaptersForTitle(bookTitle)
{
    clearContentAreas();
    BookDatabase.getChapters(bookTitle,{
    callback:function(titles) 
    {
      var titleArea=dwr.util.byId('bookTitleContentArea');
      var html='<h3>Chapters for <div id="chaptersForTitle"><i>'+bookTitle+'</i></div></h3>';
      
      BookDatabase.getAuthors(bookTitle,{
          async:false,
          callback:function(authors) 
          { 
            html+='Authors: '+authors;
          }
        });
      titleArea.innerHTML=html;
      var cellFuncs = [function(title) {
 
            return '<a href="#" onclick="getChapterContent(\''+bookTitle+'\', \''+title+'\');">'+title+'</a>';
          }
          ];
      dwr.util.removeAllRows('bookChapters');
      dwr.util.addRows( "bookChapters",titles , cellFuncs, { escapeHtml:false });    
      var insertChapterArea=dwr.util.byId('insertChapterArea');

      var numberOfVotes=0;      
       BookDatabase.getNumberOfVotes(bookTitle,{
          async:false,
          callback:function(n) 
          { 
            numberOfVotes=n;            
          }
        });

      var totalNumberOfAuthors=0;      
       BookDatabase.getNumberOfAuthors(bookTitle,{
          async:false,
          callback:function(n) 
          { 
            totalNumberOfAuthors=n;            
          }
        });
      var voteDisabled='';
       BookDatabase.haveIVoted(bookTitle,{
          async:false,
          callback:function(haveIVoted) 
          { 
            if(haveIVoted==true)
            {
              voteDisabled='DISABLED';
            }            
          }
        });
         
      insertChapterArea.innerHTML='<a href="#" onclick="addChapter(\''+bookTitle+'\');">Add new chapter</a>';
       BookDatabase.amIAuthor(bookTitle,{
          async:false,
          callback:function(amIAuthor) 
          { 
            if(amIAuthor==true)
            {
              var voteArea=dwr.util.byId('voteArea');
              var voteAreaHtml='<input type="button" value="Vote for publish" '+voteDisabled+' onclick="voteForPublish(\''+bookTitle+'\');">';;
              voteAreaHtml+='<br/>Total votes: '+numberOfVotes+'/'+totalNumberOfAuthors+'.';
              voteArea.innerHTML=voteAreaHtml;
            }
            
          }
        });
    }
    });
}

function voteForPublish(bookTitle)
{
    var confirmation=confirm('You can not take back your vote. Are you sure that you want to vote?');
    if(confirmation)
    {   BookDatabase.voteForPublish(bookTitle,{
          callback:function() 
          { 
            getChaptersForTitle(bookTitle);
          }
        });
    }
}

function refreshChapterIfVisible(bookTitle)
{
  var chaptersForTitle=dwr.util.byId('chaptersForTitle');
  if(chaptersForTitle!=null || chaptersForTitle!=undefined)
  {
    if(chaptersForTitle.innerHTML.indexOf(bookTitle)>-1)
    {
      getChaptersForTitle(bookTitle);
    }
  }
}

function clearChapterViewIfVisible(bookTitle)
{
  var chaptersForTitle=dwr.util.byId('chaptersForTitle');
  if(chaptersForTitle!=null || chaptersForTitle!=undefined)
  {
    if(chaptersForTitle.innerHTML.indexOf(bookTitle)>-1)
    {
      clearContentAreas();
    }
  }
}

function bookIsPublished(bookTitle)
{
  alert('Book '+bookTitle+' is published. Authors have voted.');
  clearChapterViewIfVisible(bookTitle);
}

function getChapterContent(bookTitle,chapterTitle)
{
  var readonly="";
  var editor="";
  BookDatabase.isChapterEdited(bookTitle,chapterTitle,{
    async:false,
    callback:function(isEdited) 
    { 
      if(isEdited!=null)
      {
        readonly="readonly";
        editor=isEdited;
      }
    }
  });
  BookDatabase.getChapterContent(bookTitle,chapterTitle,{
    callback:function(chapterContent) 
    {
      var editChapterArea=dwr.util.byId('editChapterArea');
      var html='<h3>'+chapterTitle+'</h3>';
      if(editor!="")
      {
        html+='Edited by '+editor+'<br/>';
      }
      html+='<textarea '+readonly+' id="chapterContentTextArea" rows="10" cols="60">'+chapterContent+'</textarea><br/>';
      if(readonly=="")
      {
        html+='<input type="button" value="Save" onclick="saveChapterContent(\''+bookTitle+'\',\''+chapterTitle+'\');">';
        html+='<input type="button" value="Cancel" onclick="cancelChapterContentEdit(\''+bookTitle+'\',\''+chapterTitle+'\');">'; 
      }
      else
      {
        html+='<input type="button" value="Cancel" onclick="closeChapterContentEdit();">'; 
      
      }
      editChapterArea.innerHTML=html;      
    }
    });
    return false;
}

function cancelChapterContentEdit(bookTitle,chapterTitle)
{
      BookDatabase.cancelChapterEdit(bookTitle,chapterTitle);
      var editChapterArea=dwr.util.byId('editChapterArea');
      editChapterArea.innerHTML='';
      return false;
}

function closeChapterContentEdit()
{
    var editChapterArea=dwr.util.byId('editChapterArea');
    editChapterArea.innerHTML='';
    return false;
}

function saveChapterContent(bookTitle,chapterTitle)
{
  var editChapterArea=dwr.util.byId('chapterContentTextArea');
  var content=editChapterArea.value;
  BookDatabase.saveChapterContent(bookTitle,chapterTitle,content,{
    callback:function() 
    {
      setFeedback('Content saved.');
    }
    });
  return false;
}

function setFeedback(feedback)
{
  var feedbackArea=dwr.util.byId('feedbackArea');
  feedbackArea.innerHTML=(new Date())+":<br/>"+feedback;
}

function startNewBook()
{
  var bookTitle=prompt("Book title:");
  if(bookTitle!=null)
  {
    BookDatabase.addNewBook(bookTitle,refreshBookLists);
  }
  return false;
}

function addChapter(bookTitle)
{
  //dialog to ask book title
  var chapterTitle=prompt("Chapter name:");
  if(chapterTitle!=null)
  {
    BookDatabase.insertChapter(bookTitle,chapterTitle,{
      callback:function() 
       {
        getChaptersForTitle(bookTitle);      
      }
      });
  }
  return false;
}

function refreshBookLists()
{
  getBookLists();
}

function clearContentAreas()
{
  var area=dwr.util.byId('feedbackArea');
  area.innerHTML='';

  area=dwr.util.byId('bookTitleContentArea');
  area.innerHTML='';

  dwr.util.removeAllRows('bookChapters');

  area=dwr.util.byId('insertChapterArea');
  area.innerHTML='';

  area=dwr.util.byId('voteArea');
  area.innerHTML='';
  
  area=dwr.util.byId('editChapterArea');
  area.innerHTML='';
}

</script>

</head>
<body onload="showUsersOnline();">
<div id="maincontainer">

<div id="topsection">
<div class="innertube">
<h1>Book Authoring</h1>
<h4>Welcome <i><%=(String) session.getAttribute("username")%></i></h4>
</div>
</div>

<div id="contentwrapper">
<div id="contentcolumn">
<div id="bookContent" class="innertube">
<div id="feedbackArea"></div>
<div id="bookTitleContentArea"></div>
<table cellpadding="0" cellspacing="0">
  <tbody id="bookChapters">
  </tbody>
</table>

<div id="insertChapterArea"></div>
<div id="voteArea"></div>

<div id="editChapterArea"></div>

</div>
</div>
</div>

<div id="leftcolumn">
<div class="innertube">
<table cellpadding="0" cellspacing="0">
  <thead>
    <tr>
      <td><b>Books in process</b></td>
    </tr>
  </thead>
  <tbody id="booksInProgress">
  </tbody>
  <tfoot>
    <tr>
      <td><a href="#" onclick="startNewBook();">Start new book</a></td>
    </tr>
  </tfoot>
</table>


<table cellpadding="0" cellspacing="0">
  <thead>
    <tr>
      <td><b>Published books</b></td>
    </tr>
  </thead>
  <tbody id="publishedBooks">
  </tbody>
</table>

<table cellpadding="0" cellspacing="0">
  <thead>
    <tr>
      <td><b>Authors online</b></td>
    </tr>
  </thead>
  <tbody id="authorsOnline">
  </tbody>
</table>

<input id="logoutButton" type="button" value="Logout"
  onclick="logout();return false;"></div>

</div>

<div id="footer">Stylesheet by <a
  href="http://www.dynamicdrive.com/style/">Dynamic Drive CSS
Library</a></div>

</div>
<script type="text/javascript">
getBookLists();
</script>
</body>
</html>
