package chatroom;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.ScriptProxy;

public class Login {

	public Login() {

	}

	public String doLogin(String userName) {
		UserDatabase userDb = UserDatabase.getInstance();
		if (!userDb.isUserLogged(userName)) {
			userDb.login(userName);
			WebContext webContext = WebContextFactory.get();
			HttpServletRequest request = webContext.getHttpServletRequest();
			HttpSession session = request.getSession();
			session.setAttribute("username", userName);
			// script id for communication with specific user
			// using Reverse Ajax
			String scriptId = webContext.getScriptSession().getId();
			session.setAttribute("scriptSessionId", scriptId);
			(new Util()).setUserSessionId(userName, scriptId);
			updateUsersOnline();
			return "mainpage.jsp";
		} else {
			return "loginFailed.html";
		}
	}

	public void doLogout() {
		try {
			WebContext ctx = WebContextFactory.get();
			HttpServletRequest request = ctx.getHttpServletRequest();
			HttpSession session = request.getSession();
			Util util = new Util();
			String userName = util.getCurrentUserName(session);
			util.removeUserSessionId(userName);
			UserDatabase.getInstance().logout(userName);
			session.removeAttribute("username");
			session.removeAttribute("scriptSessionId");
			session.invalidate();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		updateUsersOnline();
	}

	private void updateUsersOnline() {
		WebContext webContext = WebContextFactory.get();
		ServletContext servletContext = webContext.getServletContext();
		ServerContext serverContext = ServerContextFactory.get(servletContext);
		webContext.getScriptSessionsByPage("");
		String contextPath = servletContext.getContextPath();
		if (contextPath != null) {
			Collection<ScriptSession> sessions = serverContext
					.getScriptSessionsByPage(contextPath + "/mainpage.jsp");
			ScriptProxy proxy = new ScriptProxy(sessions);
			proxy.addFunctionCall("showUsersOnline");
		}

	}

	public List<String> getUsersOnline() {
		UserDatabase userDb = UserDatabase.getInstance();
		return userDb.getLoggedInUsers();
	}
}
