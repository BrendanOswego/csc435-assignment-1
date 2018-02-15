package mainpackage.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mainpackage.data.API;
import mainpackage.data.Book;
import mainpackage.data.BooksList;
import mainpackage.helpers.PrintHelper;

public class BooksServlet extends HttpServlet {
  private static final long serialVersionUID = 459012421686181870L;

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    res.setContentType("text/html");
    HttpSession session = req.getSession();
    PrintWriter out = res.getWriter();
    PrintHelper.instance().printTop(req, res);
    out.println("<p>Add Books <a href='/assignment-1/books/add'>here</a>");
    if (session.getAttribute("booksList") != null) {
      BooksList booksList = (BooksList) session.getAttribute("booksList");
      for (Book b : booksList.getBooks().values()) {
        out.println("<p>" + b.getTitle() + ", " + b.getAuthor() + "</p>");
      }
    }
    PrintHelper.instance().printBottom(out);
    out.close();
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    PrintWriter out = res.getWriter();
    String title, author;
    try {
      title = req.getParameterValues("title")[0];
      author = req.getParameterValues("author")[0];
    } catch (NullPointerException e) {
      out.println("title/author cannot be undefined");
      return;
    }
    API.instance().postBook(req.getSession(), new Book(title, author));
    doGet(req, res);
  }

}