import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    br.close();

    int F = Integer.parseInt(st.nextToken()); // 건물 층수
    int S = Integer.parseInt(st.nextToken()); // 시작
    int G = Integer.parseInt(st.nextToken()); // 목표
    int U = Integer.parseInt(st.nextToken()); // 엘리베이터 버튼
    int D = Integer.parseInt(st.nextToken()); // 엘리베이터 버튼

    Set<Integer> set = new HashSet<>(); // 방문한 층 저장
    Queue<int[]> queue = new LinkedList<>();

    set.add(S);
    queue.add(new int[] {S, 0});

    while (!queue.isEmpty()) {
      int[] floor = queue.poll(); // 현재 있는 층
      if (floor[0] == G) {
        System.out.println(floor[1]);
        return;
      }

      int nextU = floor[0] + U;
      int nextD = floor[0] - D;

      if (nextU <= F && set.add(nextU)) {
        queue.offer(new int[] {nextU, floor[1] + 1});
      }

      if (nextD >= 1 && set.add(nextD)) {
        queue.offer(new int[] {nextD, floor[1] + 1});
      }
    }

    System.out.println("use the stairs");
  }
}
