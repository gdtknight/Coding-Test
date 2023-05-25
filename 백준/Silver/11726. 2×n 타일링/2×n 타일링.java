import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
      
    if (N == 1) {
      System.out.println(1);
      return;
    } else if (N == 2) {
      System.out.println(2);
      return;
    }

    int[] result = new int[N];
    result[0] = 1;
    result[1] = 2;

    for (int i = 2; i < N; i++) {
      result[i] = (result[i-1] + result[i-2]) % 10007;
    }
    System.out.println(result[N-1]);

    br.close();
  }
}
