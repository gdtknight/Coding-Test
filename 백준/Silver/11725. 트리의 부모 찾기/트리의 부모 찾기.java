import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] parent = new int[N + 1];

    StringTokenizer st;

    ArrayList<Integer>[] adjust = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
      adjust[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      adjust[v1].add(v2);
      adjust[v2].add(v1);
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(1);

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      for (int child : adjust[cur]) {
        if (parent[child] == 0) {
          parent[child] = cur;
          queue.offer(child);
        }
      }
    }

    for (int idx = 2; idx <= N; idx++) {
      System.out.println(parent[idx]);
    }

    br.close();
  }
}
