import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((t1, t2) -> Integer.compare(t1[1], t2[1]));
        
        for (int[] target : targets) {
            pq.offer(target);
        }
        
        int[] prev = pq.poll();
        
        while(!pq.isEmpty()) {
            if (prev[1] > pq.peek()[0]) pq.poll();
            else {
                prev = pq.poll();  
                answer++;
            }
        }
        
        return answer;
    }
}