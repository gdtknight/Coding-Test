import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    static int groupIdx = -1;
    static int[][] dirs = new int[][]{
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    
    public int solution(int[][] land) {
        int answer = 0;
        
        Map<Integer, Integer> sizeMap = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> check = new HashSet<>();
        
        for (int y = 0; y < land.length; y++) {
            for (int x = 0; x < land[0].length; x++) {
                // 석유가 있는 경우 뽑아내고 표시
                if (land[y][x] == 1) {
                    int curSize = 0;
                    
                    land[y][x] = groupIdx;
                    
                    queue.offer(new int[]{y, x});
                    curSize++;
                    
                    while(!queue.isEmpty()) {
                        int[] pos = queue.poll();
                        
                        for (int[] dir : dirs) {
                            int nextY = pos[0] + dir[0];
                            int nextX = pos[1] + dir[1];
                            
                            if (nextY < 0
                                || land.length <= nextY
                                || nextX < 0
                                || land[0].length <= nextX
                                || land[nextY][nextX] == 0
                                || land[nextY][nextX] < 0) continue;
                            
                            land[nextY][nextX] = groupIdx;
                            curSize++;
                            queue.offer(new int[]{nextY, nextX});
                        }
                    }
                    
                    sizeMap.put(groupIdx, curSize);
                    
                    groupIdx--;
                }
            }
        }
        
        for (int x = 0; x < land[0].length; x++) {
            int amount = 0;
            
            check.clear();
            
            for (int y = 0; y < land.length; y++) {
                if (land[y][x] == 0 || check.contains(land[y][x])) continue; 
                
                int curGroup = land[y][x];
                amount += sizeMap.get(curGroup);
                check.add(curGroup);
            }
            
            answer = Math.max(answer, amount);
        }
        
        return answer;
    }
}
