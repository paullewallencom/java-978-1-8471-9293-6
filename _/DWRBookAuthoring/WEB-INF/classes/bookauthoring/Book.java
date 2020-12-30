package bookauthoring;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Book {

	private String title="";
	private List<String> authors=new Vector<String>();
	private Map<String,String> chapters=new LinkedHashMap<String,String>();
	
	private List<String> votesForPublish=new Vector<String>();
	
	private boolean isPublished=false;
	
	public Book()
	{
		
	}
	
	
	
	public void insertChapter(String chapterTitle, String chapterContent)
	{
		chapters.put(chapterTitle, chapterContent);
	}
	
	public Collection<String> getChapterTitles()
	{
		return chapters.keySet();
	}
	
	public String getChapter(String chapterTitle)
	{
		return chapters.get(chapterTitle);
	}
	
	public void addAuthor(String author)
	{
		if(!authors.contains(author)){
			authors.add(author);
		}
	}
	
	public List<String> getAuthors()
	{
		return authors;
	}
	
	public int getNumberOfAuthors()
	{
		return authors.size();
	}
	
	public int getNumberOfVotes()
	{
		return votesForPublish.size();
	}
	
	public void voteForPublish(String author)
	{
		if(authors.contains(author))
		{
			if(!votesForPublish.contains(author))
			{
				votesForPublish.add(author);
				if(votesForPublish.size()==authors.size())
				{
					isPublished=true;
				}
			}
		}
	}
	
	public boolean isPublished()
	{
		return isPublished;
	}
	
	public boolean haveIVoted(String author)
	{
		return votesForPublish.contains(author);
	}
	
	public String getTitle() {		
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String toString() {
		StringBuffer sb=new StringBuffer();
		sb.append("<h1>");
		sb.append(getTitle());
		sb.append("</h1>");
		sb.append("<p><b>Authors: </b><i>");
		for(String author : getAuthors())
		{
			sb.append(author);
			sb.append(';');

		}
		sb.append("</i></p>");
		for (String title : getChapterTitles())
		{
			sb.append("<h3>");
			sb.append(title);
			sb.append("</h3>");
			sb.append(getChapter(title));
			
		}
		return sb.toString();
	}

	
}
