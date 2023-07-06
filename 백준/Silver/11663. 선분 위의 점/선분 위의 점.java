import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11663번 - 선분 위의 점
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] dots = new int[N];

    st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < N; i++) {
      dots[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(dots);

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      int start = Math.min(v1, v2);
      int end = Math.max(v1, v2);

      int lIdx = 0;
      int rIdx = dots.length;

      while (lIdx < rIdx) {
        int mid = (lIdx + rIdx) / 2;

        if (dots[mid] < start) lIdx = mid + 1;
        else rIdx = mid;
      }

      int startIdx = lIdx;

      lIdx = 0;
      rIdx = dots.length;

      while (lIdx < rIdx) {
        int mid = (lIdx + rIdx) / 2;

        if (dots[mid] < end) lIdx = mid + 1;
        else rIdx = mid;
      }

      int lastIdx = lIdx;

      if (lastIdx == dots.length || end != dots[lastIdx]) bw.write((lastIdx - startIdx) + "\n");
      else bw.write((lastIdx - startIdx + 1)+"\n");
    }
    bw.flush();
    br.close();
    bw.close();
  }
}
