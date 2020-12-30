<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Chatroom</title>
<link href="styles.css" rel="stylesheet" type="text/css" />
<%
	if (session.getAttribute("username") == null
			|| session.getAttribute("username").equals("")) {
		//if not logged in and trying to access this page
		//do nothing, browser shows empty page
		return;
	}
%>
<script type='text/javascript' src='/DWRChatRoom/dwr/interface/Login.js'></script>
<script type='text/javascript' src='/DWRChatRoom/dwr/interface/ChatRoomDatabase.js'></script>
<script type='text/javascript' src='/DWRChatRoom/dwr/engine.js'></script>
<script type='text/javascript' src='/DWRChatRoom/dwr/util.js'></script>  

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
          function(user) {
 
            return '<i>'+user+'</i>';
          }
          ];
    Login.getUsersOnline({
    callback:function(users) 
    {
      dwr.util.removeAllRows('usersOnline');
      dwr.util.addRows( "usersOnline",users, cellFuncs, { escapeHtml:false });
    }
    });
}

function getPreviousMessages()
{
    ChatRoomDatabase.getChatContent({
    callback:function(messages) 
    {
      var chatArea=dwr.util.byId('chatArea');
      var html="";
      for(index in messages)
      {
         var msg=messages[index];
         html+=msg;
      }
      chatArea.innerHTML=html;
      var chatAreaHeight = chatArea.scrollHeight;
      chatArea.scrollTop = chatAreaHeight;
    }
    });

}

function newMessage(message)
{
  var chatArea=dwr.util.byId('chatArea');
  var oldMessages=chatArea.innerHTML;
  chatArea.innerHTML=oldMessages+message;  
  var chatAreaHeight = chatArea.scrollHeight;
  chatArea.scrollTop = chatAreaHeight;
}

function sendMessageIfEnter(event)
{
  if(event.keyCode == 13)
  {
    sendMessage();
  }
}

function sendMessage()
{
    var message=dwr.util.byId('messageText');
    var messageText=message.value;
    ChatRoomDatabase.postMessage(messageText);
    message.value='';
}

</script>

</head>
<body onload="showUsersOnline();">
<div id="maincontainer">

<div id="topsection">
<div class="innertube">
<h1>Chatroom</h1>
<h4>Welcome <i><%=(String) session.getAttribute("username")%></i></h4>
</div>
</div>

<div id="contentwrapper">
<div id="contentcolumn">
<div id="chatArea" style="width: 600px; height: 300px; overflow: auto">
</div>
<div id="inputArea">
<h4>Send message</h4>
<input id="messageText" type="text" size="50" onkeyup="sendMessageIfEnter(event);"><input type="button" value="Send msg" onclick="sendMessage();">
</div>
</div>
</div>

<div id="leftcolumn">
<div class="innertube">

<table cellpadding="0" cellspacing="0">
  <thead>
    <tr>
      <td><b>Users online</b></td>
    </tr>
  </thead>
  <tbody id="usersOnline">
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
getPreviousMessages();
</script>

</body>
</html>
