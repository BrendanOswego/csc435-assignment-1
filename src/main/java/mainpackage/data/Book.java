package mainpackage.data;

public class Book {

  private final int id;
  private String title;
  private String author;

  public Book(String title, String author) {
    this.title = title;
    this.author = author;

    this.id = ID.getNewID();
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getID() {
    return id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}