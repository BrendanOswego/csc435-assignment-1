package mainpackage.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mainpackage.data.API;
import mainpackage.data.Book;
import mainpackage.data.BooksList;

public class BookServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    res.setContentType("application/json");
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    PrintWriter out = res.getWriter();
    int id;
    try {
      id = Integer.parseInt(req.getPathInfo().split("/")[1]);
      Book book = BooksList.instance().getBooks().get(id);
      if (book != null)
        out.println(gson.toJson(book));
      else
        out.println(gson.toJson(API.instance().errorMessage("Could not find Book with ID: " + id)));
    } catch (NumberFormatException e) {
      out.println(API.instance().errorMessage("Invalid ID"));
      return;
    }
  }
}