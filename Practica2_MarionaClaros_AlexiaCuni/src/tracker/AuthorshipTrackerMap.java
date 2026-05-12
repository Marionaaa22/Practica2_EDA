package tracker;

import java.util.*;

public class AuthorshipTrackerMap { //TODO: Complete header

	/* DO NOT MODIFY THIS */
	private Map<Author, Set<Book>> authorBookMap;
	/* DO NOT ADD MORE ATTRIBUTES */
	
	public AuthorshipTrackerMap() {
		/* COMPLETE */

	}
	
	/* COMPLETE */
	

	
	/* Complimentary method */
	private Author findAuthorByName(String name) {
		for (Author a : authorBookMap.keySet())
			if (name.equalsIgnoreCase(a.getName())) {
				return a;
			}
		return null;
	}

	public static class BookTitleComparator { //TODO: Complete header
		//TODO: Write a comparator that compares book titles
	}

	public static class AuthorNameComparator { //TODO: Complete header
		//TODO: Write a comparator that compares author names
	}
	
}
