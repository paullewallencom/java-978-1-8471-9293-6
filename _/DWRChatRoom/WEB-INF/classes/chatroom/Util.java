package chatroom;

import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

public class Util {
	
	private static Map<String,String> userScriptSessions=new Hashtable<String,String>();

	public Util()
	{
		
	}
	
	public void setUserSessionId(String userName,String scriptSessionId)
	{
		userScriptSessions.put(userName, scriptSessionId);
	}
	
	public String getUserSessionId(String userName)
	{
		return userScriptSessions.get(userName);
	}

	public void removeUserSessionId(String userName)
	{
		userScriptSessions.remove(userName);
	}

	public String getCurrentUserName()
	{
		//get user name from session
		WebContext ctx = WebContextFactory.get();
		HttpServletRequest request = ctx.getHttpServletRequest();
		HttpSession session=request.getSession();
		return getCurrentUserName(session);
	}

	public String getCurrentUserName(HttpSession session)
	{
		String userName=(String)session.getAttribute("username");
		return userName;
	}

}
