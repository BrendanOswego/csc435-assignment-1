package mainpackage.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mainpackage.helpers.PrintHelper;

public class Home extends HttpServlet {
  private static final long serialVersionUID = 459012421686181870L;

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    PrintHelper.instance().printTop(req, res);
    out.println("<p>Welcome to my Library Web Application!</p>");
    out.println(
        "<p>Here is the <a href='https://github.com/BrendanOswego/csc435-assignment-1'>link to the github repo</a> this project is under, which includes documentation</p>");
    PrintHelper.instance().printBottom(out);
  }

}