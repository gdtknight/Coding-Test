import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] wires) {
        boolean[][] towerMap = new boolean[n + 1][n + 1];
        
        for (int i = 0; i < wires.length; i++) {
            towerMap[wires[i][0]][wires[i][1]] = true;
            towerMap[wires[i][1]][wires[i][0]] = true;
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            towerMap[wires[i][0]][wires[i][1]] = false;
            towerMap[wires[i][1]][wires[i][0]] = false;
            
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            int v1Count = 0;
            int v2Count = 0;
            
            boolean[] visited = new boolean[n + 1];
            
            Queue<Integer> queue = new LinkedList<>();
            
            visited[v1] = true;
            v1Count++;
            
            queue.offer(v1);
            
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for (int j = 1; j <= n; j++) {
                    if (cur != j && !visited[j] && towerMap[cur][j]) {
                        visited[j] = true;
                        queue.offer(j);
                        v1Count++;
                    }
                }
            }
            
            visited = new boolean[n + 1];
            queue.offer(v2);
            visited[v2] = true;
            v2Count++;
            
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                
                for (int j = 1; j <= n; j++) {
                    if (cur != j && !visited[j] && towerMap[cur][j]) {
                        visited[j] = true;
                        queue.offer(j);
                        v2Count++;
                    }
                }
            }
            
            answer = Math.min(answer, Math.abs(v1Count - v2Count));
            
            towerMap[wires[i][0]][wires[i][1]] = true;
            towerMap[wires[i][1]][wires[i][0]] = true;
        }
        
        
        return answer;
    }
}