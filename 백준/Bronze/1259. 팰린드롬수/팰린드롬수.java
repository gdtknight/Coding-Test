import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line = br.readLine();
    StringBuilder sb = new StringBuilder();
    boolean find;
    while (!"0".equals(line)) {
      find = true;
      for (int i = 0; i < line.length() / 2; i++) {
        if (line.charAt(i) != line.charAt(line.length() - 1 - i)) {
          find = false;
          break;
        }
      }
      if (find) sb.append("yes\n");
      else sb.append("no\n");

      line = br.readLine();
    }

    System.out.println(sb);
  }
}
