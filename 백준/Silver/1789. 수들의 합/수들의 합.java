import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1789번 - 수들의 합
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 최대값 4_294_967_295
    long S = Long.parseLong(br.readLine());
    br.close();

    long left = 1;
    long right = S / 2 + 1;

    while (left <= right) {
      long mid = (left + right) / 2;
      long sum = mid * (mid + 1) / 2;

      if (sum == S) {
        System.out.println(mid);
        return;
      } else if (sum < S) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    System.out.println(left - 1);
  }
}
