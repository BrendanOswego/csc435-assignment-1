package mainpackage.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mainpackage.data.Book;
import mainpackage.data.BooksList;
import mainpackage.helpers.PrintHelper;

public class AddBook extends HttpServlet {
  private static final long serialVersionUID = 3510403208860237748L;

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    String cssPath = req.getContextPath() + "/css/styles.css";
    PrintHelper.instance().printTop(out, cssPath);
    out.println("<form method='POST'>");
    out.println("<input type='text' name='title' placeholder='Title'/>");
    out.println("<input type='text' name='author' placeholder='Author'/>");
    out.println("<input type='submit' name='submit'/>");
    out.println("</form>");
    PrintHelper.instance().printBottom(out);
    out.close();
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    String cssPath = req.getContextPath() + "/css/styles.css";
    PrintHelper.instance().printTop(out, cssPath);
    String title = req.getParameterValues("title")[0];
    String author = req.getParameterValues("author")[0];
    if (title.trim().isEmpty() || author.trim().isEmpty()) {
      out.println("<p>Title/Author cannot be empty</p>");
      return;
    }
    HttpSession session = req.getSession();
    BooksList booksList;
    if (session.getAttribute("booksList") == null) {
      booksList = new BooksList();
    } else {
      booksList = (BooksList) session.getAttribute("booksList");
    }
    if (!booksList.containsBook(title, author)) {
      if (booksList.addBook(new Book(title, author))) {
        out.println(
            "<p>book added successfully to see all books please go to <a href='/assignment-1/books'>the book page</a></p>");
        req.getSession().setAttribute("booksList", booksList);
      }
    } else {
      out.println(
          "<p>Book is already added in the session try <a href='/assignment-1/books/add'>adding a new book</a></p>");
    }
    PrintHelper.instance().printBottom(out);
    out.close();
  }
}