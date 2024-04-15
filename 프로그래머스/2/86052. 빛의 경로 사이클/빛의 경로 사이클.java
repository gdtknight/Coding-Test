import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    static int count = 0;
    static int[][] dirs = new int[][] {
        /**
        *
        * (0) (1) (2) (3) 
        * (1)      3
        * (2)  2   X   0
        * (3)      1
        *
        *  S : 0 -> 0, 1 -> 1, 2 -> 2, 3 -> 3      =>  prev
        *  L : 1 -> 0, 0 -> 3, 2 -> 1, 3 -> 2      =>  prev - 1
        *  R : 0 -> 1, 1 -> 2, 2 -> 3, 3 -> 0      =>  prev + 1
        *
        *
        **/
        
        {0,  1}, // 오른쪽
        {1,  0}, // 아래쪽
        {0, -1}, // 왼쪽
        {-1, 0}  // 위쪽
    };
    
    public int[] solution(String[] grid) {
        final int ROWS = grid.length;
        final int COLS = grid[0].length();
        
        List<Integer> answerList = new ArrayList<>();
        
        Set<Edge> visited = new HashSet<>();
        
        for (int x = 0; x < ROWS; x++) {
            for (int y = 0; y < COLS; y++) {
                for (int dir = 0; dir < 4; dir++) {
                    Edge current = new Edge(x, y, dir);
                    
                    int count = 0;
                    boolean flag = visited.add(current);
                    
                    while (flag) {
                        count += 1;
                        
                        int nextX = (current.x + dirs[current.dir][0] + grid.length) % grid.length;
                        int nextY = (current.y + dirs[current.dir][1] + grid[0].length()) % grid[0].length();
                        int nextDir = current.dir;
                        
                        if (grid[nextX].charAt(nextY) == 'L') {
                            nextDir = (current.dir - 1 + dirs.length) % dirs.length;
                        } else if (grid[nextX].charAt(nextY) == 'R') {
                            nextDir = (current.dir + 1) % dirs.length ;
                        }
                        
                        current = new Edge(nextX, nextY, nextDir);
                        
                        flag = visited.add(current);
                    }
                    
                    if (count <= ROWS * COLS * 4) {
                        answerList.add(count);
                    }
                }
            }
        }
        
        return answerList.stream()
            .filter(i -> 0 < i)
            .sorted()
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}

class Edge {
    int x;
    int y;
    int dir;
    
    Edge(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        
        Edge e = (Edge) o;
        
        return x == e.x && y == e.y && dir == e.dir;
    }
    
    public int hashCode() {
        return ((x * 31) + y) * 31 + dir;
    }
}