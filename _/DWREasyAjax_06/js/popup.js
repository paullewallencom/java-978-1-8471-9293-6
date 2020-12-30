//<script type="text/javascript"><!--
/* Original script by: www.jtricks.com
 * Version: 20070301
 * Latest version:
 * www.jtricks.com/javascript/window/box.html
 *
 * Modified by Sami Salkosuo.
 */
// Moves the box object to be directly beneath an object.
function move_box(an, box)
{
    var cleft = 0;
    var ctop = 0;
    var obj = an;

    while (obj.offsetParent)
    {
        cleft += obj.offsetLeft;
        ctop += obj.offsetTop;
        obj = obj.offsetParent;
    }

    box.style.left = cleft + 'px';

    ctop += an.offsetHeight + 8;

    // Handle Internet Explorer body margins,
    // which affect normal document, but not
    // absolute-positioned stuff.
    if (document.body.currentStyle &&
        document.body.currentStyle['marginTop'])
    {
        ctop += parseInt(
            document.body.currentStyle['marginTop']);
    }

    box.style.top = ctop + 'px';
}

var popupMenuInitialised=false;
// Shows a box if it wasn't shown yet or is hidden
// or hides it if it is currently shown
function show_box(html, width, height, borderStyle,id)
{
    // Create box object through DOM
    var boxdiv = document.getElementById(id);
    boxdiv.style.display='block';
    if(popupMenuInitialised==false)
    {
      //boxdiv = document.createElement('div');
      boxdiv.setAttribute('id', id);
      boxdiv.style.display = 'block';
      boxdiv.style.position = 'absolute';
      boxdiv.style.width = width + 'px';
      boxdiv.style.height = height + 'px';
      boxdiv.style.border = borderStyle;
      boxdiv.style.textAlign = 'right';
      boxdiv.style.padding = '4px';
      boxdiv.style.background = '#FFFFFF';
      boxdiv.style.zIndex='99';
      popupMenuInitialised=true;
      //document.body.appendChild(boxdiv);
    }

    var contentId=id+'Content';
    var contents = document.getElementById(contentId);
    if(contents==null)
    {
      contents = document.createElement('div');
      contents.setAttribute('id', id+'Content');
      contents.style.textAlign= 'left';
      boxdiv.contents = contents;
      boxdiv.appendChild(contents);
    
    }
    move_box(html, boxdiv);

    contents.innerHTML= html;

    return false;
}

function hide_box(id)
{
    document.getElementById(id).style.display='none';
    var boxdiv = document.getElementById(id+'Content');
    if(boxdiv!=null)
    {
      boxdiv.parentNode.removeChild(boxdiv);
      
    } 
    return false;
}

function getAbsoluteDivs()
{
    var arr = new Array();
    var all_divs = document.body.getElementsByTagName("DIV");
    var j = 0;

    for (i = 0; i < all_divs.length; i++)
        if (all_divs.item(i).style.position=='absolute')
        {
            arr[j] = all_divs.item(i);
            j++;
        }

    return arr;
}

function bringToFront(obj)
{
    if (!document.getElementsByTagName)
        return;

    var divs = getAbsoluteDivs();
    var max_index = 0;
    var cur_index;

    // Compute the maximal z-index of
    // other absolute-positioned divs
    for (i = 0; i < divs.length; i++)
    {
        var item = divs[i];
        if (item == obj ||
            item.style.zIndex == '')
            continue;

        cur_index = parseInt(item.style.zIndex);
        if (max_index < cur_index)
        {
            max_index = cur_index;
        }
    }

    obj.style.zIndex = max_index + 1;
}

//--></script>
