import java.util.PriorityQueue;
import java.util.Stack;

class Solution {
    /*
     * n : 정점 개수
     * s, a, b : 시작점, 도착점1, 도착점2
     * fares : int[] fare : fares -> fare[0], fare[1] 사이 요금 (비용, 가중치) fare[2]
     **/
    public long solution(int n, int s, int a, int b, int[][] fares) {
        long[][] map = new long[n + 1][n + 1];
        long answer = 0;
        
        for (int i = 1; i < n + 1; i++) {
            map[i][i] = 0;
            for (int j = 1; j < n + 1; j++) {
                if (i == j)
                    continue ;
                map[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int[] fare: fares) {
            int u = fare[0] < fare[1] ? fare[0] : fare[1];
            int v = fare[0] < fare[1] ? fare[1] : fare[0];
            map[u][v] = fare[2];
            map[v][u] = fare[2];
        }
        
        for (int m = 1; m < n + 1; m++) {
            for (int u = 1; u < n + 1; u++) {
                for (int v = 1; v < n + 1; v++) {
                    if (u != v && (map[u][m] + map[m][v]) < map[u][v])
                        map[u][v] = map[u][m] + map[m][v];
                }
            }
        }
        answer = map[s][a] + map[s][b];
        for (int m = 1; m < n + 1; m++) {
            if (m == s)
                continue ;
            if ((long) (map[s][m] + map[m][a] + map[m][b]) < (long) answer)
                answer = map[s][m] + map[m][a] + map[m][b];
        }
        return answer;
    }
 // 1차 풀이 시도 실패
 //   public int solution(int n, int s, int a, int b, int[][] fares) {
 //       int answer = 0;
 //       int[][] mst = prim(n, s, a, b, fares);
 //       Stack<Integer> path1 = new Stack<>();
 //       Stack<Integer> path2 = new Stack<>();
 //       // for (int v = 1; v <= n; v++) {
 //       //     System.out.printf("%d's parent: %d\n", v, mst[0][v]);
 //       // }
 //       
 //       int v = a;
 //       while (v != s) {
 //           path1.push(v);
 //           v = mst[0][v];
 //       }
 //       path1.push(v);
 //       
 //       v = b;
 //       while (v != s) {
 //           path2.push(v);
 //           v = mst[0][v];
 //       }
 //       path2.push(v);
 //       
 //       while ((!path1.isEmpty() && !path2.isEmpty()) && (path1.peek() == path2.peek())) {
 //           v = path1.pop();
 //           path2.pop();
 //           if ((!path1.isEmpty() && !path2.isEmpty()) && (path1.peek() == path2.peek())) {
 //               // System.out.printf("%d -> %d (%d)\n", v, path1.peek(), mst[1][v]);
 //               answer += mst[1][path1.peek()];
 //           }
 //       }
 //       while (!path1.isEmpty()) {
 //           answer += mst[1][path1.pop()];
 //       }
 //       while (!path2.isEmpty()) {
 //           answer += mst[1][path2.pop()];
 //       }
 //           
 //       return answer;
 //   }
	//public int[][] prim(int n, int start, int a, int b, int[][] fares) {
 //       int[][] answer = new int[2][n + 1];
	//    int[] parent = answer[0];
	//    // key[v] = INF for all v
	//    int[] key = answer[1];
	//    boolean[] visited = new boolean[n + 1];
	//    
	//    for (int idx = 1; idx <= n; idx++) {
	//        key[idx] = Integer.MAX_VALUE;
	//        visited[idx] = false;
	//    }
	//    
	//    // parent[s] = -1;
	//	  parent[start] = -1;
	//        
	//	// key[start] = 0
	//    key[start] = 0;
	//    
    //    PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[0], e2[0]));
    //
	//	// min-heap push (0, start)
	//    pq.offer(new int[]{0, start});
	//    
	//    
	//	// while heap not empty:
	//	//     w, u = pop
	//	//     if u already visited: continue
	//	//     mark u visited
	//	//     for each (u, v, weight):
	//	//         if not visited[v] and weight < key[v]:
	//	//             key[v] = weight
	//	//             parent[v] = u
	//	//             push (key[v], v) into heap
	//    while (!pq.isEmpty()) {
	//        int[] e = pq.poll();
	//        
	//        int w = e[0];
	//        int u = e[1];
	//        
	//        if (visited[u])
	//            continue ;
	//        
	//        visited[u] = true;
	//        for (int[] fare: fares) {
	//            int v;
	//            
	//            if (fare[0] == u)
	//                v = fare[1];
	//            else if (fare[1] == u)
	//                v = fare[0];
	//            else
	//                continue ;
	//            int weight = fare[2];
	//            if (!visited[v] && weight < key[v]) {
	//                key[v] = weight;
	//                parent[v] = u;
	//                pq.offer(new int[]{key[v], v});
	//            }
	//        }
	//    }
	//    
	//	return answer; 
	//}
}