package mainpackage.data;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class API {
  private static API instance = null;

  private API() {
  }

  public static API instance() {
    if (instance == null)
      instance = new API();
    return instance;
  }

  public boolean postBook(HttpSession state, Book b) {
    BooksList list = BooksList.instance();
    if (list.addBook(b)) {
      state.setAttribute("booksList", list);
      return true;
    }
    return false;
  }

  public Map<String, String> errorMessage(String reason) {
    Map<String, String> message = new HashMap<>();
    message.put("error", reason);
    return message;
  }
}