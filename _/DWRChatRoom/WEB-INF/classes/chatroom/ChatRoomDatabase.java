package chatroom;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.ScriptProxy;

public class ChatRoomDatabase {


	private static List<String> chatContent = new Vector<String>();

	public ChatRoomDatabase() {

	}

	public void postMessage(String message) {
		String user = (new Util()).getCurrentUserName();
		if (user != null) {
			Date time = new Date();
			StringBuffer sb = new StringBuffer();
			sb.append(time.toString());
			sb.append(" <b><i>");
			sb.append(user);
			sb.append("</i></b>:  ");
			sb.append(message);
			sb.append("<br/>");
			String newMessage=sb.toString();
			chatContent.add(newMessage);
			postNewMessage(newMessage);
			
		}
	}

	public List<String> getChatContent() {
		return chatContent;
	}

	private ScriptProxy getScriptProxyForSessions() {
		WebContext webContext = WebContextFactory.get();
		ServletContext servletContext = webContext.getServletContext();
		ServerContext serverContext = ServerContextFactory.get(servletContext);
		webContext.getScriptSessionsByPage("");
		String contextPath = servletContext.getContextPath();
		if (contextPath != null) {
			Collection<ScriptSession> sessions = serverContext
					.getScriptSessionsByPage(contextPath + "/mainpage.jsp");
			ScriptProxy proxy = new ScriptProxy(sessions);
			return proxy;
		}
		return null;
	}

	public void postNewMessage(String newMessage) {
		ScriptProxy proxy = getScriptProxyForSessions();
		if (proxy != null) {
			proxy.addFunctionCall("newMessage",newMessage);
		}
	}

}
