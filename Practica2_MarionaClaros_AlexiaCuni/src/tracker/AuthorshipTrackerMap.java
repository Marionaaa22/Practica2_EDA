package tracker;

import java.util.*;

public class AuthorshipTrackerMap implements AuthorshipTracker { //TODO: Complete header

	/* DO NOT MODIFY THIS */
	private Map<Author, Set<Book>> authorBookMap;
	/* DO NOT ADD MORE ATTRIBUTES */
	
	public AuthorshipTrackerMap() {
		authorBookMap = new HashMap<>();
	}

	/* Complimentary method */
	private Author findAuthorByName(String name) {
		for (Author a : authorBookMap.keySet())
			if (name.equalsIgnoreCase(a.getName())) {
				return a;
			}
		return null;
	}

	@Override
	public int addBooksToAuthor(Author author, Collection<Book> books) {
		if(!authorBookMap.containsKey(author)){
			authorBookMap.put(author, new TreeSet<>());
		}

		int afegit = 0;

		for (Book b : books){
			if (authorBookMap.get(author).add(b)){
				afegit ++;
			}
		}

		return afegit;
	}

	@Override
	public int addAuthorsToBook(Collection<Author> authors, Book book) {
		int afegit = 0;

		for(Author a: authors){
			if (!authorBookMap.containsKey(a)) {
				authorBookMap.put(a, new TreeSet<>());
			}

			if (authorBookMap.get(a).add(book)) {
				afegit++;
			}
		}

		return afegit;
	}

	@Override
	public SortedSet<Author> findAuthors(BookTag tag) {
		SortedSet<Author> resultat = new TreeSet<>(new AuthorNameComparator());

		for (Author a : authorBookMap.keySet()) {

			for (Book b : authorBookMap.get(a)) {

				if (b.getTag().equals(tag)) {
					resultat.add(a);
				}
			}
		}

		return resultat;
	}

	@Override
	public SortedSet<Book> findBooks(String authorName) {
		Author author = findAuthorByName(authorName);

		if (author == null) {
			return new TreeSet<>();
		}

		return new TreeSet<>(authorBookMap.get(author));
	}

	@Override
	public SortedSet<Book> findBooksInCommon(String name1, String name2) {
		SortedSet<Book> result = new TreeSet<>();

		Author autor1 = findAuthorByName(name1);
		Author autor2 = findAuthorByName(name2);

		if (autor1 == null || autor2 == null) {
			return result;
		}

		for (Book b : authorBookMap.get(autor1)) {

			if (authorBookMap.get(autor2).contains(b)) {
				result.add(b);
			}
		}

		return result;
	}

	public static class BookTitleComparator implements Comparator<Book>{

		@Override
		public int compare(Book b1, Book b2) {
			return b1.getTitle().compareToIgnoreCase(b2.getTitle());
		}

	}

	public static class AuthorNameComparator implements Comparator<Author>{
		@Override
		public int compare(Author autor1, Author autor2) {
			return autor1.getName().compareToIgnoreCase(autor2.getName());
		}
	}
	
}
