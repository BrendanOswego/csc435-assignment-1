package mainpackage.data;

import java.util.List;
import java.util.Map;

public interface IBooks {
  public boolean addBook(Book b);

  public boolean removeBook(Book b);

  public List<Book> searchForBooks(String[] info);

  public Map<Integer, Book> getBooks();
}