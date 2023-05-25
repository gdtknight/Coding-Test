import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] cases = new int[N];
    int max = 0;
      
    for (int i = 0; i < N; i++) {
      cases[i] = Integer.parseInt(br.readLine());
      if (max < cases[i]) {
        max = cases[i];
      }
    }

    int[] factorial = new int[max+1];

    factorial[0] = 1;
    factorial[1] = 1;

    for (int i = 2; i <= max; i++) {
      factorial[i] = i * factorial[i-1];
    }
      
    StringBuilder sb = new StringBuilder();
      
    for (int i = 0 ; i < N; i++) {
      sb.append(solution(cases[i], factorial));
      if (i != N-1) {
        sb.append("\n");
      }
    }
      
    System.out.println(sb.toString());

    br.close();
  }

  public static int solution(int num, int[] fact) {
    int answer = 0;

    for (int threeCnt = 0; threeCnt <= num / 3; threeCnt++) {
      int remain = num - threeCnt * 3;

      for (int twoCnt = 0; twoCnt <= remain / 2; twoCnt++) {
        int oneCnt = remain - twoCnt * 2;

        int sum = threeCnt + twoCnt + oneCnt;
        answer += fact[sum] / (fact[threeCnt] * fact[twoCnt] * fact[oneCnt]);

      }

    }

    return answer;
  }
}