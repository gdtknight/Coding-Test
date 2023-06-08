import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    // 1 ≤ N ≤ 200
    // 1 ≤ K ≤ 200

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] memo = new int[K + 1][N + 1];

    for (int num = 1; num <= N; num++) {
      memo[1][num] = 1;
    }

    for (int k = 2; k <= K; k++) {
      memo[k][1] = k;
      for (int num = 2; num <= N; num++) {
        memo[k][num] = (memo[k][num - 1] + memo[k - 1][num]) % 1_000_000_000;
      }
    }

    System.out.println(memo[K][N]);

    br.close();
  }

}