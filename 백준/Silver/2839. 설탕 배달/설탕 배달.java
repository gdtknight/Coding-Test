import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    System.out.println(solution(N));

    br.close();
  }

  public static int solution(int N) {
    if (N < 3 || N == 4) {
      return -1;
    } else if (N == 3 || N == 5) {
      return 1;
    }

    int fiveCnt = N / 5;
    int threeCnt = 0;
    int remain = N % 5;

    if (remain == 0) {
      return fiveCnt;
    } else if (remain % 3 == 0) {
      return fiveCnt + remain / 3;
    }

    while (N - fiveCnt * 5 - threeCnt * 3 > 0) {
      fiveCnt = fiveCnt > 0 ? fiveCnt - 1 : 0;
      threeCnt++;
      if ((N - fiveCnt * 5) % 3 == 0) {
        return fiveCnt + (N - fiveCnt * 5) / 3;
      }
    }

    return -1;
  }

}