package mainpackage.data;

import java.util.ArrayList;
import java.util.List;

public class BooksList implements IBooks {

  private List<Book> books;

  public BooksList() {
    books = new ArrayList<Book>();
  }

  public boolean addBook(Book b) {
    return books.add(b);
  }

  public boolean removeBook(Book b) {
    return books.remove(b);
  }

  public List<Book> searchForBooks(String[] info) {
    List<Book> temp = new ArrayList<Book>();
    for (int i = 0; i < info.length; i++) {
      for (Book b : books) {
        if (b.getTitle().contains(info[i]) || b.getAuthor().contains(info[i])) {
          temp.add(b);
        }
      }
    }
    return temp;
  }

  public List<Book> getBooks() {
    return books;
  }

}