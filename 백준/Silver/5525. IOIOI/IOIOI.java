import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int sLen = Integer.parseInt(br.readLine());
    String S = br.readLine();

    String pN = "I" + "OI".repeat(N);

    int idx = S.indexOf(pN);
    int answer = 0;
    while (idx != -1) {
      answer++;
      idx = S.indexOf(pN, idx + 2);
    }
    System.out.println(answer);
  }
}
