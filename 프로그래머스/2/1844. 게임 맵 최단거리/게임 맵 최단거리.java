import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static final int[][] dirs = new int[][]{
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    
    // maps = n x m
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        Queue<Pos> queue = new LinkedList<>();
        
        queue.offer(new Pos(0, 0, 1));
        visited[0][0] = true;
        
        outer:
        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            for (int[] dir : dirs) {
                int nextX = cur.getX() + dir[0];
                int nextY = cur.getY() + dir[1];
                int nextCount = cur.getCount() + 1;
                
                if (nextX < 0 
                    || nextY < 0 
                    || nextX >= maps.length 
                    || nextY >= maps[0].length
                    || maps[nextX][nextY] == 0) {
                    continue;
                }
                
                
                if (nextX == n-1 && nextY == m-1) {
                    answer = nextCount;
                    break outer;
                }
                
                if(!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new Pos(nextX, nextY, nextCount));
                }
            }
        }
        
        return answer;
    }
}

class Pos {
    private int x;
    private int y;
    private int count;
    
    public Pos(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getCount() {
        return this.count;
    }
}