package mainpackage.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mainpackage.data.Book;
import mainpackage.data.BooksList;
import mainpackage.helpers.PrintHelper;

public class Books extends HttpServlet {
  private static final long serialVersionUID = 459012421686181870L;

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    HttpSession session = req.getSession();
    String cssPath = req.getContextPath() + "/css/styles.css";
    PrintHelper.instance().printTop(out, cssPath);
    out.println("<p>Add Books <a href='/assignment-1/books/add'>here</a>");
    if (session.getAttribute("booksList") != null) {
      BooksList booksList = (BooksList) session.getAttribute("booksList");
      for (Book b : booksList.getBooks()) {
        out.println("<p>" + b.getTitle() + ", " + b.getAuthor() + "</p>");
      }
    }
    PrintHelper.instance().printBottom(out);
    out.close();
  }

}