import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        /**
         *
         * 메인 아이디어
         * : 우선순위큐를 사용하면 간단하게 해결됨
         *
         **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 4
        final int N = Integer.parseInt(br.readLine());
        final int[][] pairs = new int[N][2];

        StringTokenizer st = null;

        final PriorityQueue<int[]> qualityPq = new PriorityQueue<>(
                (p1, p2) -> p1[0] == p2[0]
                        ? Integer.compare(p1[1], p2[1])
                        : Integer.compare(p2[0], p1[0])
        );

        final PriorityQueue<int[]> pricePq = new PriorityQueue<>(
                (p1, p2) -> p1[1] == p2[1]
                        ? Integer.compare(p2[0], p1[0])
                        : Integer.compare(p1[1], p2[1])
        );


        for (int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(br.readLine(), " ");

            pairs[idx][0] = Integer.parseInt(st.nextToken());
            pairs[idx][1] = Integer.parseInt(st.nextToken());

            qualityPq.offer(pairs[idx]);
            pricePq.offer(pairs[idx]);
        }

        int[] qualityPair1 = qualityPq.poll();
        int[] qualityPair2 = qualityPq.poll();

        int[] pricePair1 = pricePq.poll();
        int[] pricePair2 = pricePq.poll();

        StringBuilder answer = new StringBuilder();
        answer.append(qualityPair1[0] + " " + qualityPair1[1] + " ");
        answer.append(qualityPair2[0] + " " + qualityPair2[1] + "\n");
        answer.append(pricePair1[0] + " " + pricePair1[1] + " ");
        answer.append(pricePair2[0] + " " + pricePair2[1]);

        System.out.println(answer);

        br.close();
    }
}
