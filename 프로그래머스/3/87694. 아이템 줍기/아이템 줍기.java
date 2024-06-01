import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static final int MAX_SIZE = 50;
    // 3, 2, 1, 0 : 동 서 남 북
    static final int[][] DIRS = new int[][] {
        { 0,  1}, // 북
        { 0, -1}, // 남
        {-1,  0}, // 서
        { 1,  0}  // 동
    };
    
    public int solution(
        final int[][] RECTANGLES,
        final int CHARACTER_X,
        final int CHARACTER_Y,
        final int ITEM_X,
        final int ITEM_Y
    ) {
        // xx1111 -> (xx: 사각형 번호) + 동서남북 플래그
        int[][] map = new int[MAX_SIZE + 1][MAX_SIZE + 1];
        boolean[][] check = new boolean[MAX_SIZE + 1][MAX_SIZE + 1];
        
        // 모든 사각형에서 사방으로 이동이 가능하다고 가정한 후에 못가는 길 표시 최종적으론 갈 수 있는 길만 남게됨
        for (int[] rectangle : RECTANGLES) {
            int leftX  = rectangle[0];
            int leftY  = rectangle[1];
            int rightX = rectangle[2];
            int rightY = rectangle[3];
            
            map[leftX][leftY]   = map[leftX][leftY]   | ((1 << 3) + (0 << 2) + (0 << 1) + (1 << 0)); // 좌측 하단
            map[leftX][rightY]  = map[leftX][rightY]  | ((1 << 3) + (0 << 2) + (1 << 1) + (0 << 0)); // 좌측 상단
            map[rightX][leftY]  = map[rightX][leftY]  | ((0 << 3) + (1 << 2) + (0 << 1) + (1 << 0)); // 우측 하단
            map[rightX][rightY] = map[rightX][rightY] | ((0 << 3) + (1 << 2) + (1 << 1) + (0 << 0)); // 우측 상단
                
            for (int x = leftX + 1; x < rightX; x++) {
                map[x][leftY]  = map[x][leftY]  | ((1 << 3) + (1 << 2) + (0 << 1) + (0 << 0)); // 아랫변
                map[x][rightY] = map[x][rightY] | ((1 << 3) + (1 << 2) + (0 << 1) + (0 << 0)); // 윗변
            }
            
            for (int y = leftY + 1; y < rightY; y++) {
                map[leftX][y]  = map[leftX][y]  | ((0 << 3) + (0 << 2) + (1 << 1) + (1 << 0)); // 좌변
                map[rightX][y] = map[rightX][y] | ((0 << 3) + (0 << 2) + (1 << 1) + (1 << 0)); // 우변
            }
        }
        
        for (int[] rectangle : RECTANGLES) {
            int leftX  = rectangle[0];
            int leftY  = rectangle[1];
            int rightX = rectangle[2];
            int rightY = rectangle[3];
            
            // 꼭지점 세팅 - 못가는 방향 설정
            // map[leftX][leftY]   = map[leftX][leftY]   & ((1 << 3) + (0 << 2) + (0 << 1) + (1 << 0)); // 좌측 하단 : 서쪽 남쪽
            // map[leftX][rightY]  = map[leftX][rightY]  & ((1 << 3) + (0 << 2) + (1 << 1) + (0 << 0)); // 좌측 상단 : 서쪽 북쪽
            // map[rightX][leftY]  = map[rightX][leftY]  & ((0 << 3) + (1 << 2) + (0 << 1) + (1 << 0)); // 우측 하단 : 동쪽 남쪽
            // map[rightX][rightY] = map[rightX][rightY] & ((0 << 3) + (1 << 2) + (1 << 1) + (0 << 0)); // 우측 상단 : 동쪽 북쪽
                
            for (int x = leftX + 1; x < rightX; x++) {
                // 아랫변은 북쪽으로 못감
                map[x][leftY]  = map[x][leftY]  & ((1 << 3) + (1 << 2) + (1 << 1) + (0 << 0)); 
                
                // 윗변은 남쪽으로 못감
                map[x][rightY] = map[x][rightY] & ((1 << 3) + (1 << 2) + (0 << 1) + (1 << 0)); 
            }
            
            for (int y = leftY + 1; y < rightY; y++) {
                // 좌변은 동쪽으로 못감
                map[leftX][y]  = map[leftX][y]  & ((0 << 3) + (1 << 2) + (1 << 1) + (1 << 0));
                // 우변은 서쪽으로 못감
                map[rightX][y] = map[rightX][y] & ((1 << 3) + (0 << 2) + (1 << 1) + (1 << 0));
            }
        }
        
        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new int[]{CHARACTER_X, CHARACTER_Y});
        
        int[][] visited = new int[MAX_SIZE + 1][MAX_SIZE + 1];
        
        visited[CHARACTER_X][CHARACTER_Y] = 1;
        
        while(!bfsQueue.isEmpty()) {
            int[] current = bfsQueue.poll();
            
            int curX = current[0];
            int curY = current[1];
            
            if (curX == ITEM_X && curY == ITEM_Y) {
                break;
            }
            
            for (int shift = 0; shift < 4; shift++) {
                int nextX = curX + DIRS[shift][0];
                int nextY = curY + DIRS[shift][1];
                
                if (nextX < 1 || nextY < 1 || MAX_SIZE < nextX || MAX_SIZE < nextY) continue;
                
                if ((map[curX][curY] & (1 << shift)) == (1 << shift) && visited[nextX][nextY] == 0) {
                    visited[nextX][nextY] = visited[curX][curY] + 1;
                    bfsQueue.offer(new int[]{nextX, nextY});
                }
            }
        }
        
        return visited[ITEM_X][ITEM_Y] - 1;
    }
}
