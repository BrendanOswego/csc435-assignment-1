package mainpackage.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BooksList implements IBooks {

  private static BooksList instance = null;
  private Map<Integer, Book> books;

  private BooksList() {
    books = new HashMap<Integer, Book>();
  }

  public static BooksList instance() {
    if (instance == null)
      instance = new BooksList();
    return instance;
  }

  public boolean addBook(Book b) {
    if (!containsBook(b.getTitle(), b.getAuthor())) {
      books.put(b.getID(), b);
      return true;
    }
    return false;
  }

  public boolean removeBook(Book b) {
    if (books.remove(b.getID()) != null)
      return true;
    return false;
  }

  public List<Book> searchForBooks(String[] info) {
    List<Book> temp = new ArrayList<Book>();
    for (int i = 0; i < info.length; i++) {
      for (Book b : books.values()) {
        if (b.getTitle().contains(info[0]) || b.getAuthor().contains(info[i])) {
          temp.add(b);
        }
      }
    }
    return temp;
  }

  public boolean containsBook(String title, String author) {
    for (Book b : books.values()) {
      if (b.getTitle().equalsIgnoreCase(title) && b.getAuthor().equalsIgnoreCase(author))
        return true;
    }
    return false;
  }

  public Map<Integer, Book> getBooks() {
    return books;
  }

}