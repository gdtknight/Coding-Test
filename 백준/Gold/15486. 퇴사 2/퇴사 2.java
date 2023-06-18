import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    // -      1일   2일   3일  4일  5일    6일  7일
    // Ti	   3     5    1	   1    2     4    2
    // Pi	  10    20   10   20   15    40  200
    // Pi/Ti   3.33  4   10   20    7.5  10  100

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] income = new int[N + 2];

    int maxIncome = 0;
    for (int today = 1; today <= N; today++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int Ti = Integer.parseInt(st.nextToken());
      int Pi = Integer.parseInt(st.nextToken());
      maxIncome = Math.max(maxIncome, income[today]);
      if (today + Ti <= N + 1) {
        income[today + Ti] = Math.max(income[today + Ti], maxIncome + Pi);
      }
    }

    System.out.println(Math.max(income[N + 1], maxIncome));

    br.close();
  }
}
