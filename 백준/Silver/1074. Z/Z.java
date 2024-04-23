import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    final int N = Integer.parseInt(st.nextToken());
    final int R = Integer.parseInt(st.nextToken());
    final int C = Integer.parseInt(st.nextToken());

    // System.out.println("N : " + N + ", R : " + R + ", C : " + C);

    int n = N;
    int start = 0;
    int row = R;
    int col = C;

    while (0 <= --n) {
      int len = (int) Math.pow(2, n);
      int rFlag = row / len;
      int cFlag = col / len;

      if (rFlag == 0 && cFlag == 0) {

      } else if (rFlag == 0 && cFlag == 1) {
        start += ((int) Math.pow(len, 2));
      } else if (rFlag == 1 && cFlag == 0) {
        start += ((int) Math.pow(len, 2)) * 2;
      } else {
        start += ((int) Math.pow(len, 2)) * 3;
      }

      // System.out.println("rFlag : " + rFlag + ", cFlag : " + cFlag + ", start : " + start);

      row = row % len;
      col = col % len;
    }

    System.out.println(start);

    br.close();
  }
}
