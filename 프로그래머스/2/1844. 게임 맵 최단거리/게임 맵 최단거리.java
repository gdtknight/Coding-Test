import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static final int[][] DIRS = new int[][] {
        { 0,  1}, // 동
        { 0, -1}, // 서
        {-1,  0}, // 남
        { 1,  0}  // 북
    };
    
    // maps = n x m
    public int solution(int[][] maps) {
        int answer = -1;
        
        Queue<int[]> queue = new LinkedList<>();
        
        final int ROWS = maps.length;
        final int COLS = maps[0].length;
        
        boolean[][] visited = new boolean[ROWS][COLS];
        
        queue.offer(new int[]{0, 0});
        
        visited[0][0] = true;
        
        outer:
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            int row = cur[0];
            int col = cur[1];
            
            for (int[] dir : DIRS) {
                int nextRow = cur[0] + dir[0];
                int nextCol = cur[1] + dir[1];
                
                if (nextRow < 0
                    || nextCol < 0
                    || ROWS <= nextRow
                    || COLS <= nextCol
                    || maps[nextRow][nextCol] == 0
                    || visited[nextRow][nextCol]
                   ) {
                    continue;
                }
                
                if (nextRow == (ROWS - 1) && nextCol == (COLS - 1)) {
                    return maps[row][col] + 1;
                }
                
                visited[nextRow][nextCol] = true;
                queue.offer(new int[]{nextRow, nextCol});
                maps[nextRow][nextCol] = maps[row][col] + 1;
            }
        }
        
        return -1;
    }
}
