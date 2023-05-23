import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int answer = 0;
    int N = Integer.parseInt(br.readLine());
    int sLen = Integer.parseInt(br.readLine());
    String S = br.readLine();

    for (int startIdx = 0; startIdx < S.length(); startIdx++) {
      if (S.charAt(startIdx) == 'I') {
        int count = 0;
        for (int idx = startIdx + 1; idx < S.length() - 1; idx += 2) {
          if (S.charAt(idx) == 'O' && S.charAt(idx + 1) == 'I') {
            count++;
          } else {
            break;
          }
        }

        if (count >= N) {
          answer += (count - N + 1);
        }

        startIdx = startIdx + count * 2;
      }
    }

    System.out.println(answer);
  }
}
