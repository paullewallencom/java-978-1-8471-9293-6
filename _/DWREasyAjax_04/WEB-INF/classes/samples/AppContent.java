package samples;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Vector;

public class AppContent {

	public AppContent()
	{
		
	}
	
	public List<String> getContent(String contentId)
	{
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(
		"samples/"+contentId+".html");
		String content=streamToString(is);
		List<String> contentList=new Vector<String>();
		//Javascript within script tag will be extracted and sent separately to client
		for(String script=getScript(content);!script.equals("");script=getScript(content))
		{
			contentList.add(script);
			content=removeScript(content);
		}
		//content list will have all the javascript
		//functions, last element is executed last
		//and all other before html content
		if(contentList.size()>1)
		{
			contentList.add(contentList.size()-1, content);
		}
		else
		{
			contentList.add(content);
		}
		return contentList;
	}
	
	public List<String> getLetters()
	{
		List<String> letters=new Vector<String>();
		char[] l=new char[1];
		for(int i=65;i<91;i++)
		{
			l[0]=(char)i;
			letters.add(new String(l));
		}
		return letters;
	}
	
	public String removeScript(String html)
	{
		//removes first script element
		int sIndex=html.toLowerCase().indexOf("<script ");
		if(sIndex==-1)
		{
			return html;
		}
		int eIndex=html.toLowerCase().indexOf("</script>")+9;
		return html.substring(0, sIndex)+html.substring(eIndex);
	}

	public String getScript(String html)
	{
		//returns first script element
		int sIndex=html.toLowerCase().indexOf("<script ");
		if(sIndex==-1)
		{
			return "";
		}
		int eIndex=html.toLowerCase().indexOf("</script>")+9;
		return html.substring(sIndex, eIndex);
	}
	
	public String streamToString(InputStream is)
	{
		String content="";
		try
		{
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		for(int b=is.read();b!=-1;b=is.read())
		{
			baos.write(b);
		}
		content=baos.toString();
		}
		catch(IOException ioe)
		{
			content=ioe.toString();
		}
		return content;
	}
}
