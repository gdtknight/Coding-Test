import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  private static int N, M, L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());

    List<Integer> stations = new ArrayList<>();
    stations.add(0);
    stations.add(L);

    st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < N; i++) {
      stations.add(Integer.parseInt(st.nextToken()));
    }

    stations.sort(Integer::compare);

    br.close();

    int min = 1;
    int max = L - 1;

    while (min <= max) {
      int mid = min + (max - min) / 2;
      if (mid == 0) break;

      int cnt = 0;

      for (int idx = 0; idx < stations.size() - 1; idx++) {
        cnt += (stations.get(idx + 1) - stations.get(idx) - 1) / mid;
      }

      if (cnt > M) {
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }

    System.out.println(min);

    br.close();
  }
}
