import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(final int N, int[][] edges) {
        boolean[][] map = new boolean[N + 1][N + 1];
        
        for (int[] edge : edges) {
            map[edge[0]][edge[1]] = true;
            map[edge[1]][edge[0]] = true;
        }
        
        Queue<Integer> bfsQueue = new LinkedList<>();
        
        int[] count = new int[N + 1];
        
        count[1] = 1;
        
        bfsQueue.offer(1);
        
        int maxCnt = 1;
        
        while(!bfsQueue.isEmpty()) {
            int current = bfsQueue.poll();
            maxCnt = Math.max(maxCnt, count[current]);
            
            for (int to = 1; to <= N; to++) {
                if (current == to) continue;
                
                if (map[current][to] && count[to] == 0) {
                    count[to] = count[current] + 1; 
                    bfsQueue.offer(to);
                }
            }
        }
        
        int answer = 0;
        
        System.out.println("MAX COUNT : " + maxCnt);
        
        for (int idx = 2; idx <= N; idx++) {
            System.out.print(count[idx] + " ");
            if (count[idx] == maxCnt) answer++;
        }
        
        return answer;
    }
}