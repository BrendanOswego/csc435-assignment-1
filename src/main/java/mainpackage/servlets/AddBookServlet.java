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
import mainpackage.helpers.PrintHelper;

public class AddBookServlet extends HttpServlet {
  private static final long serialVersionUID = 3510403208860237748L;

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    PrintHelper.instance().printTop(req, res);
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
    PrintHelper.instance().printTop(req, res);
    String title, author;
    try {
      title = req.getParameterValues("title")[0];
      author = req.getParameterValues("author")[0];
    } catch (NullPointerException e) {
      out.println("<p>Title/Author cannot be empty</p>");
      return;
    }
    HttpSession state = req.getSession();
    boolean created = API.instance().postBook(state, new Book(title, author));
    if (created)
      out.println(
          "<p>Book add successfully, click <a href='/assignment-1/books'>here</a> to go back to books page</p>");
    else
      out.println("<p>Something went wrong when trying to add book</p>");
    PrintHelper.instance().printBottom(out);
    out.close();
  }
}