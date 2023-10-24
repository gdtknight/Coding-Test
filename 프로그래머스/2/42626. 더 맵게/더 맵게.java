import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        while (pq.size() > 1) {
            if (pq.peek() < K) {
                answer++;
                int one = pq.poll();
                int two = pq.poll();
                pq.offer(one + two * 2);
            } else {
                break;
            }
        }
        
        if (pq.size() == 1 && pq.peek() < K) {
            return -1;
        }
        
        return answer;
    }
}