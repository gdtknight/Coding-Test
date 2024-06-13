import java.util.Set;
import java.util.HashSet;

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(final int N, int[][] results) {
        
        // 그래프 초기화
        boolean[][] map = new boolean[N + 1][N + 1];
        
        for (int[] result : results) {
            map[result[0]][result[1]] = true;
        }
        
        // 각 노드에서 다른 노드로 갈 수 있는지 확인
        boolean[][] dest = new boolean[N + 1][N + 1];
        
        for (int start = 1; start <= N; start++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(start);
            
            Queue<Integer> bfsQueue = new LinkedList<>();
            bfsQueue.offer(start);
            
            while(!bfsQueue.isEmpty()) {
                int current = bfsQueue.poll();
                
                for (int to = 1; to <= N; to++) {
                    if (map[current][to] && visited.add(to))
                        bfsQueue.offer(to);
                }
            }
            
            for (int to : visited) {
                if (start == to) continue;
                
                dest[start][to] = true;
            }
        }
        
        // 순위 결정자 확인
        int answer = 0;
        
        for (int col = 1; col <= N; col++) {
            int cnt = 0;
            
            for (int row = 1; row <= N; row++) {
                if (dest[row][col]) cnt++;
                else if (dest[col][row]) cnt++;
            }
            
            if (cnt == N - 1) answer++; 
        }
        
        return answer;
    }
}