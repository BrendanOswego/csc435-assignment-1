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

public class AddBook extends HttpServlet {
  private static final long serialVersionUID = 3510403208860237748L;

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    out.println("<form method='POST'>");
    out.println("<label>Title:</label><input type='text' name='title'/>");
    out.println("<label>Author:</label><input type='text' name='author'/>");
    out.println("<input type='submit' name='submit'/>");
    out.println("</form>");
    out.close();
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    String title = req.getParameterValues("title")[0];
    String author = req.getParameterValues("author")[0];
    HttpSession session = req.getSession();
    BooksList booksList;
    if (session.getAttribute("booksList") == null) {
      booksList = new BooksList();
    } else {
      booksList = (BooksList) session.getAttribute("booksList");
    }
    if (booksList.addBook(new Book(title, author))) {
      out.println("<p>book added successfully</p>");
    }
    req.getSession().setAttribute("booksList", booksList);
    out.close();
  }
}