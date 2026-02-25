import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(String[] maps) {
        int HEIGHT = maps.length;
        int WIDTH = maps[0].length();
        
        int[][] dirs = new int[][]{
            {1, 0},
            {0, -1},
            {-1, 0},
            {0, 1}
        };
        
        int answer = 0;
        int[][] distance = new int[HEIGHT][WIDTH];
        
        Queue<Pos> bfs = new LinkedList<>();
        
        for (int h = 0; h < HEIGHT; h++) {
            for (int w = 0; w < WIDTH; w++) {
                distance[h][w] = -1;
                if (maps[h].charAt(w) == 'L') {
                    distance[h][w] = 0;
                    bfs.offer(new Pos(w, h));
                }
            }
        }
        
        Pos pos = null;
        boolean flagS = false;
        boolean flagE = false;
        
        while (!bfs.isEmpty()) {
            if (flagS && flagE)
                return (answer);
            
            pos = bfs.poll();
            
            if (!flagS && maps[pos.h].charAt(pos.w) == 'S') {
                flagS = true;
                answer += distance[pos.h][pos.w];
            }
            
            if (!flagE && maps[pos.h].charAt(pos.w) == 'E') {
                flagE = true;
                answer += distance[pos.h][pos.w];
            }
            
            for (int[] dir : dirs) {
                Pos newPos = new Pos(pos.w + dir[0], pos.h + dir[1]);
                
                if (newPos.w < 0 || WIDTH <= newPos.w
                    || newPos.h < 0 || HEIGHT <= newPos.h
                    || maps[newPos.h].charAt(newPos.w) == 'X'
                    || distance[newPos.h][newPos.w] != -1)
                    continue ;
                
                distance[newPos.h][newPos.w] = distance[pos.h][pos.w] + 1;
                bfs.offer(newPos);
            }
        }
       
        if (flagS && flagE)
            return (answer);
        
        return (-1);
    }
}

class Pos {
    int w;
    int h;
    
    Pos (int w, int h) {
        this.w = w;
        this.h = h;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pos))
            return false;
        Pos p = (Pos) o;
        return ((w == p.w) && (h == p.h));
    }
    
    @Override
    public int hashCode() {
        return ((w * 31) + h);
    }
}