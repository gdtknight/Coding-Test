import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int N = Integer.parseInt(br.readLine());
    int[] testCase = new int[N];

    // 1, 1, 1, 2, 2, 3, 4, 5, 7, 9

    for (int i = 0; i < N; i++) {
      testCase[i] = Integer.parseInt(br.readLine());
    }

    long[] result = new long[100];

    result[0] = 1;
    result[1] = 1;
    result[2] = 1;
    result[3] = 2;
    result[4] = 2;
    result[5] = 3;
    result[6] = 4;
    result[7] = 5;
    result[8] = 7;

    for (int j = 9; j < 100; j++) {
      result[j] = result[j - 1] + result[j - 5];
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      sb.append(result[testCase[i] - 1]);
      if (i != N - 1) {
        sb.append("\n");
      }
    }

    System.out.println(sb.toString());

    br.close();
  }

}