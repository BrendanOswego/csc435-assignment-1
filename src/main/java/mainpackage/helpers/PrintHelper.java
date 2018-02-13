package mainpackage.helpers;

import java.io.PrintWriter;

public class PrintHelper {
  private static PrintHelper instance = null;

  private PrintHelper() {
  }

  public static PrintHelper instance() {
    if (instance == null)
      instance = new PrintHelper();
    return instance;
  }

  public void printNavigation(PrintWriter out) {
    out.println("<nav class='main-nav'>");
    out.println("<ul>");
    out.println("<li><a href='/assignment-1'>Home</a></li>");
    out.println("<li><a href='/assignment-1/books'>Books</a></li>");
    out.println("<li><a href='/assignment-1/books/add'>Add Book</a></li>");
    out.println("</ul>");
    out.println("</nav>");
  }

}