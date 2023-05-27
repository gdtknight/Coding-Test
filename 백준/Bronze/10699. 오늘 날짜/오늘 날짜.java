import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println(LocalDate.now(ZoneId.systemDefault()));
  }
}
