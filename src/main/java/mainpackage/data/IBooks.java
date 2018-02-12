package mainpackage.data;

import java.util.List;

public interface IBooks {
  public boolean addBook(Book b);

  public boolean removeBook(Book b);

  public List<Book> searchForBooks(String[] info);

  public List<Book> getBooks();
}