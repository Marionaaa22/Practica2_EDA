package tracker;

import java.util.*;

public interface AuthorshipTracker {


	public int addBooksToAuthor (Author author, Collection<Book> books);


	public int addAuthorsToBook (Collection<Author> authors, Book book);


	public SortedSet<Author> findAuthors (BookTag tag);


	public SortedSet<Book> findBooks (String authorName);


	public SortedSet<Book> findBooksInCommon (String name1, String name2);

}
