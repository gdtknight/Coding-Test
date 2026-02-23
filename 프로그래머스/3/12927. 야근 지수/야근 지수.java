import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Comparator.reverseOrder());

        for (int work : works) pq.add(work);

        // N시간 동안 가장 큰 작업부터 1씩 줄이기
        while (n > 0 && !pq.isEmpty()) {
            int work = pq.poll() - 1;
            if (work > 0) pq.add(work);
            n--;
        }

        long answer = 0L;

        // 남은 작업량의 제곱 합산
        while (!pq.isEmpty()) {
            long work = pq.poll();
            answer += work * work;
        }

        return answer;
    }
}