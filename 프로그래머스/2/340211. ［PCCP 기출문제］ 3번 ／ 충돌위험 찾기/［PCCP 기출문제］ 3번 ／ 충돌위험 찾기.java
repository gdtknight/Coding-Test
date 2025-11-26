import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

class Point {
    public int r;
    public int c;
    
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
  
    public boolean equals(Object o) {
    	if (this == o) return true;
    	if (!(o instanceof Point)) return false;
    	Point p = (Point) o;
    	return (r == p.r && c == p.c);
    }
        
    public int hashCode() {
        return (r * 31 + c) * 31;
    }
}

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Queue<int[]>[] paths = new Queue[routes.length];
        HashSet<Point> crashed = new HashSet<>();
        
        for (int idx = 0; idx < routes.length; idx++) {
            // System.out.printf("================ robot%d =================\n", idx + 1);
            // System.out.printf("routes[%d].length: %d\n", idx + 1, routes[idx].length);
            // for (int route: routes[idx]) {
            //     System.out.printf("%d (%d, %d) -> ", route, points[route - 1][0], points[route - 1][1]);
            // }
            // System.out.println("end");
            paths[idx] = new LinkedList<>();
            int[] route = routes[idx];
            int[] from = new int[]{points[route[0] - 1][0], points[route[0] - 1][1]};
            paths[idx].offer(new int[]{from[0], from[1]});
            for (int i = 0; i < route.length; i++) {
                int[] to = points[route[i] - 1];
                // System.out.printf("from: (%d, %d)\n", from[0], from[1]);
                // System.out.printf("to:   (%d, %d)\n", to[0], to[1]);
                
                while (from[0] != to[0] || from[1] != to[1]) {
                    if (from[0] < to[0])
                        from[0] += 1;
                    else if (from[0] > to[0])
                        from[0] -= 1;
                    else {
                        if (from[1] < to[1])
                            from[1] += 1;
                        else if (from[1] > to[1])
                            from[1] -= 1;
                    }
                    paths[idx].offer(new int[]{from[0], from[1]});
                }
                from = new int[]{points[route[i] - 1][0], points[route[i] - 1][1]};
            }
            // for (int[] p: paths[idx]) {
            //     System.out.printf("robot%d paths: (%d, %d)\n", idx + 1, p[0], p[1]);
            // }
        }
        boolean flag = true;
        int seq = 0;
        while (flag) {
            // System.out.printf("\n============== seq: %d ===============\n", seq);
            check:
            for (int i = 0; i < routes.length - 1; i++) {
                if (paths[i].isEmpty())
                    continue ;
            	for (int j = i + 1; j < routes.length ; j++) {
                    if (paths[j].isEmpty())
                        continue ;
                    if (i == j)
                        continue ;
                    int[] p1 = paths[i].peek();
                    int[] p2 = paths[j].peek();
                    if (p1[0] == p2[0] && p1[1] == p2[1]) {
                        crashed.add(new Point(p1[0], p1[1]));
                        // System.out.printf("robot%d - robot%d crashed\n", i + 1, j + 1);
                    }
            	}
            }
            // for (Point p: crashed) {
            //     System.out.printf("crashed at (%d, %d)\n", p.r, p.c);
            // }
            answer += crashed.size();
            crashed.clear();
            flag = false;
            for (int idx = 0; idx < routes.length; idx++) {
                if (!paths[idx].isEmpty()) {
                    flag = true;
                	int[] p = paths[idx].poll();
                    // System.out.printf("[%d] robot%d: (%d, %d)\n", seq, idx + 1, p[0], p[1]);
                }
            }
            seq++;
        }
        
        return answer;
    }
}