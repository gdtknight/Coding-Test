import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[computers.length];
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                answer++;
                visited[i] = true;
                queue.offer(i);
                while(!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int j = 0; j < computers.length; j++) {
                        if (!visited[j] && computers[cur][j] == 1) {
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        return answer;
    }
}