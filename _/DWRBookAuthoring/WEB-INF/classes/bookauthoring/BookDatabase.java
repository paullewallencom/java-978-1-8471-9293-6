package bookauthoring;

import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.ScriptProxy;

public class BookDatabase {

	private static Map<String, Book> booksInProgress = new LinkedHashMap<String, Book>();
	private static Map<String, Book> publishedBooks = new LinkedHashMap<String, Book>();

	private static Map<String, String> editedChapters = new Hashtable<String, String>();

	public BookDatabase() {
	}

	public List<String> getBooksInProgressTitles() {
		return getTitles(booksInProgress.values());
	}

	public List<String> getPublishedBookTitles() {
		return getTitles(publishedBooks.values());

	}

	public Collection<String> getChapters(String bookTitle) {
		Book book = getBook(bookTitle);
		if (book != null) {
			return book.getChapterTitles();
		}
		return null;
	}

	public String isChapterEdited(String bookTitle, String chapterTitle) {
		String isEdited = editedChapters.get(bookTitle + chapterTitle);
		return isEdited;
	}

	public void cancelChapterEdit(String bookTitle, String chapterTitle) {
		editedChapters.remove(bookTitle + chapterTitle);
	}

	public List<String> getAuthors(String bookTitle) {
		Book book = getBook(bookTitle);
		if (book != null) {
			return book.getAuthors();
		}

		return null;
	}

	private List<String> getTitles(Collection<Book> books) {
		List<String> titles = new Vector<String>();
		for (Book book : books) {
			titles.add(book.getTitle());
		}
		return titles;

	}

	private Book getBook(String bookTitle) {
		return getBook(bookTitle, false);

	}

	private Book getBook(String bookTitle, boolean getGromPublishedBook) {
		if (getGromPublishedBook) {
			if (publishedBooks.containsKey(bookTitle)) {
				return publishedBooks.get(bookTitle);
			}

		} else {
			if (booksInProgress.containsKey(bookTitle)) {
				return booksInProgress.get(bookTitle);
			}
		}
		return null;

	}

	public void addNewBook(String title) {
		if (!booksInProgress.containsKey(title)) {
			Book newBook = new Book();
			newBook.setTitle(title);
			String userName = (new Util()).getCurrentUserName();
			newBook.addAuthor(userName);
			booksInProgress.put(title, newBook);
			refreshBookList();
		}
	}

	public void insertChapter(String bookTitle, String chapterTitle) {
		Book book = getBook(bookTitle);
		if (book != null) {
			String userName = (new Util()).getCurrentUserName();
			if (!book.getAuthors().contains(userName)) {
				book.addAuthor(userName);
			}
			book.insertChapter(chapterTitle, "");
			refreshChapterIfVisible(bookTitle);
		}
	}

	public String getChapterContent(String bookTitle, String chapterTitle) {
		Book book = getBook(bookTitle);
		String content = "";
		if (book != null) {
			content = book.getChapter(chapterTitle);
			if (content == null) {
				content = "";
			}
		}
		String key = bookTitle + chapterTitle;
		if (!editedChapters.containsKey(key)) {
			editedChapters.put(key, (new Util()).getCurrentUserName());
		}

		return content;
	}

	public void saveChapterContent(String bookTitle, String chapterTitle,
			String content) {
		Book book = getBook(bookTitle);
		if (book != null) {
			String userName = (new Util()).getCurrentUserName();
			if (!book.getAuthors().contains(userName)) {
				book.addAuthor(userName);
			}
			book.insertChapter(chapterTitle, content);
		}
	}

	public boolean amIAuthor(String bookTitle) {
		Book book = getBook(bookTitle);
		if (book != null) {
			String userName = (new Util()).getCurrentUserName();
			return book.getAuthors().contains(userName);
		}
		return false;
	}

	public boolean haveIVoted(String bookTitle) {
		Book book = getBook(bookTitle);
		if (book != null) {
			String userName = (new Util()).getCurrentUserName();
			return book.haveIVoted(userName);
		}
		return false;
	}

	public int getNumberOfAuthors(String bookTitle) {
		Book book = getBook(bookTitle);
		if (book != null) {
			return book.getAuthors().size();
		}
		return 0;

	}

	public int getNumberOfVotes(String bookTitle) {
		Book book = getBook(bookTitle);
		if (book != null) {
			return book.getNumberOfVotes();
		}
		return 0;

	}

	public void voteForPublish(String bookTitle) {
		Book book = getBook(bookTitle);
		if (book != null) {
			String userName = (new Util()).getCurrentUserName();
			book.voteForPublish(userName);
			if (book.isPublished()) {
				informBookPublished(bookTitle);
				booksInProgress.remove(bookTitle);
				publishedBooks.put(bookTitle, book);
				refreshBookList();
			}
			refreshChapterIfVisible(bookTitle);
		}

	}

	public String getRenderedBook(String bookTitle) {
		Book book = getBook(bookTitle, true);
		if (book != null) {
			return book.toString();
		}
		return "";
	}

	private ScriptProxy getScriptProxyForSessions()
	{
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

	public void refreshBookList() {
		ScriptProxy proxy =getScriptProxyForSessions();
		if(proxy!=null)
		{
			proxy.addFunctionCall("getBookLists");
		}
	}

	public void refreshChapterIfVisible(String bookTitle) {
		ScriptProxy proxy =getScriptProxyForSessions();
		if(proxy!=null)
		{
			proxy.addFunctionCall("refreshChapterIfVisible", bookTitle);
		}
	}

	public void informBookPublished(String bookTitle) {
		ScriptProxy proxy =getScriptProxyForSessions();
		if(proxy!=null)
		{
			proxy.addFunctionCall("bookIsPublished", bookTitle);
		}
	}

}
