package chatroom;

import java.util.List;
import java.util.Vector;

//this class holds currently logged in users
//there is no persistence
public class UserDatabase {
	
	private static UserDatabase userDatabase=new UserDatabase();
	
	private List<String> loggedInUsers=new Vector<String>();
	
	private UserDatabase()
	{
		
	}
	
	public static UserDatabase getInstance()
	{
		return userDatabase;
	}
	
	public List<String> getLoggedInUsers()
	{
		return loggedInUsers;
	}
	
	public boolean isUserLogged(String userName)
	{
		return loggedInUsers.contains(userName); 
	}
	
	public void login(String userName)
	{
		loggedInUsers.add(userName);
	}
	
	public void logout(String userName)
	{
		loggedInUsers.remove(userName);
	}
}
