import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        Queue<Integer> bfs = new LinkedList<>();
        
        for(int node = 0; node < n; node++) {
            if (visited[node]) continue;
            
            answer++;
            visited[node] = true;
            bfs.offer(node);
            
            while(!bfs.isEmpty()) {
                int cur =  bfs.poll();
                
                for (int target = 0; target < n; target++)  {
                    if (visited[target] || computers[cur][target] == 0)
                        continue;
                    
                    visited[target] = true;
                    bfs.offer(target);
                }
            }
        }
        
        return answer;
    }
}