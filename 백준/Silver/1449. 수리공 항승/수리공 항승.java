import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    if (L == 1) {
      System.out.println(N);
      return;
    }

    boolean[] fixed = new boolean[N];
    int[] pos = new int[N];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      pos[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(pos);

    fixed[0] = true;
    int cnt = 1;

    int nextPos = pos[0] + (L - 1);

    int idx = 1;
    while (idx < N) {
      if (pos[idx] <= nextPos) {
        fixed[idx] = true;
      } else {
        cnt++;
        nextPos = pos[idx] + (L - 1);
      }
      idx++;
    }

    System.out.println(cnt);

    br.close();
  }
}
