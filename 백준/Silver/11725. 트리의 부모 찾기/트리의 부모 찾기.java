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

    Map<Integer, ArrayList<Integer>> adjustListMap = new HashMap<>();

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      ArrayList<Integer> vv1 = adjustListMap.getOrDefault(v1, new ArrayList<>());
      vv1.add(v2);
      ArrayList<Integer> vv2 = adjustListMap.getOrDefault(v2, new ArrayList<>());
      vv2.add(v1);
      adjustListMap.put(v1, vv1);
      adjustListMap.put(v2, vv2);
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(1);

    while(!queue.isEmpty()) {
      int cur = queue.poll();
      ArrayList<Integer> adjustList = adjustListMap.get(cur);

      for (int child : adjustList) {
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
