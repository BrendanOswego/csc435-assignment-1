package mainpackage.data;

public class ID {
  private static int id = 0;

  public static synchronized int getNewID() {
    if (id == 0) {
      id++;
      return 0;
    }
    return id++;
  }
}