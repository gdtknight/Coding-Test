import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int checkSum = 0;
    while (st.hasMoreTokens()) {
      checkSum += (int) Math.pow(Integer.parseInt(st.nextToken()), 2);
    }
    System.out.println(checkSum % 10);

    br.close();
  }
}
