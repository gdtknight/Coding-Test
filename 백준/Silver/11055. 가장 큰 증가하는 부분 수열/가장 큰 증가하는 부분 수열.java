import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    // 1 <= N <= 1,000

    int N = Integer.parseInt(br.readLine());

    String[] strNums = br.readLine().split(" ");

    int[] nums = new int[N];
    int[] memo = new int[N];

    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(strNums[i]);
      memo[i] = nums[i];
    }

    for (int i = 1; i < N; i++) {
      for (int j = i-1; j >= 0; j--) {
        if (nums[i] > nums[j]) {
          memo[i] = memo[j] + nums[i] > memo[i] ? memo[j] + nums[i] : memo[i];
        }
      }
    }

    int maxCnt = 0;

    for (int i = 0; i < N; i++) {
      if (memo[i] > maxCnt) {
        maxCnt = memo[i];
      }
    }

    System.out.println(maxCnt);

    br.close();
  }

}