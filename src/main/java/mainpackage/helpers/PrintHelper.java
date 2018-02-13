package mainpackage.helpers;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    out.println("<li><a href='/assignment-1'>HOME</a></li>");
    out.println("<li><a href='/assignment-1/books'>BOOKS</a></li>");
    out.println("<li><a href='/assignment-1/books/add'>ADD BOOK</a></li>");
    out.println("</ul>");
    out.println("</nav>");
  }

  public void printTop(PrintWriter out, String cssPath) {
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<link rel='stylesheet' href='" + cssPath + "'>");
    out.println("</head>");
    out.println("<body>");
    printNavigation(out);
    out.println("<div class='page'>");
    out.println("<div class='page-container'>");
  }

  public void printBottom(PrintWriter out) {
    out.println("</div>");
    out.println("</div>");
    out.println("</body>");
    out.println("</html>");
  }

}