import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[][] triangle = new int[N][];

    for (int i = 0; i < N; i++) {
      triangle[i] =
          Arrays.stream(br.readLine().split(" "))
              .map(Integer::parseInt)
              .mapToInt(Integer::intValue)
              .toArray();
    }

    for (int i = 1; i < N; i++) {
      triangle[i][0] += triangle[i - 1][0];

      for (int idx = 1; idx < triangle[i].length - 1; idx++) {
        triangle[i][idx] += Math.max(triangle[i - 1][idx - 1], triangle[i - 1][idx]);
      }

      triangle[i][triangle[i].length - 1] += triangle[i - 1][triangle[i].length - 2];
    }

    int max = 0;
    for (int i = 0; i < triangle[N - 1].length; i++) {
      if (triangle[N - 1][i] > max) max = triangle[N - 1][i];
    }
    System.out.println(max);
  }
}
