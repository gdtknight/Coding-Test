import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int nextX, nextY;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        // M: rows
        // N: cols
        // M1 & M2: determines direction.
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M1 = Integer.parseInt(st.nextToken());
        int M2 = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[M + 1][N + 1];
        Set<Pos> visited = new HashSet<>();
        Queue<Pos> bfs = new LinkedList<>();
        for (int row = 1; row <= M; row++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int col = 1; col <= N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
                if (map[row][col] == 3) {
                    bfs.offer(new Pos(row, col, 0));
                    visited.add(new Pos(row, col, 0));
                }
            }
        }
        
        while (!bfs.isEmpty()) {
            Pos cur = bfs.poll();
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0)
                    nextX = cur.getX() + M1;
                else
                    nextX = cur.getX() - M1;
                for (int j = 0; j < 2; j++) {
                    if (j % 2 == 0)
                        nextY = cur.getY() + M2;
                    else
                        nextY = cur.getY() - M2;
                    if (nextX < 1 || M < nextX || nextY < 1 || N < nextY
                        || map[nextX][nextY] == 0 || map[nextX][nextY] == 2)
                        continue;
                    if (map[nextX][nextY] == 4)
                    {
                        sb.append(cur.getCount() + 1);
                        bw.write(sb.toString());
                        bw.flush();
                        bw.close();
                        br.close();
                        return ;
                    }
                    Pos nextPos = new Pos(nextX, nextY, cur.getCount() + 1);
                    if (!visited.add(nextPos)) continue;
                    bfs.offer(nextPos);
                }
            }
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0)
                    nextX = cur.getX() + M2;
                else
                    nextX = cur.getX() - M2;
                for (int j = 0; j < 2; j++) {
                    if (j % 2 == 0)
                        nextY = cur.getY() + M1;
                    else
                        nextY = cur.getY() - M1;
                    if (nextX < 1 || M < nextX || nextY < 1 || N < nextY
                        || map[nextX][nextY] == 0 || map[nextX][nextY] == 2)
                        continue;
                    if (map[nextX][nextY] == 4)
                    {
                        sb.append(cur.getCount() + 1);
                        bw.write(sb.toString());
                        bw.flush();
                        bw.close();
                        br.close();
                        return ;
                    }
                    Pos nextPos = new Pos(nextX, nextY, cur.getCount() + 1);
                    if (!visited.add(nextPos)) continue;
                    bfs.offer(nextPos);
                }
            }
        }
        
        bw.close();
        br.close();
    }
}

class Pos {
    int x;
    int y;
    int count;
    
    public Pos(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
    
    public int getX() {
        return (x);
    }
    
    public int getY() {
        return (y);
    }
    
    public int getCount() {
        return (count);
    }
    
    public boolean equals(Object o)
    {
        if (!(o instanceof Pos))
            return false;
        Pos p = (Pos) o;
        return ((x == p.x) && (y == p.y));
    }
    
    public int hashCode() {
        return ((x * 31) + y) * 31;
    }
}