import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] wires) {
        /**
        * 메인 아이디어
        * : 전선 정보를 바탕으로 인접 행렬을 생성한다.
        *   각 전선을 절단할 경우 해당 전선에 연결되어 있던 두 송전탑을 각각 시작 노드로 하여 BFS 실시.
        *   그 결과의 차이가 가장 작은 경우를 계산한다.
        */
        
        // 인접행렬 생성
        boolean[][] towerMap = new boolean[n + 1][n + 1];
        int v1, v2, cnt1, cnt2;
        
        for (int[] wire : wires) {
            towerMap[wire[0]][wire[1]] = true;
            towerMap[wire[1]][wire[0]] = true;
        }
        
        // 결과 저장
        int answer = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        
        for (int[] wire : wires) {
            // 간선 중 하나를 임의로 끊는다
            v1 = wire[0];
            v2 = wire[1];
            towerMap[v1][v2] = false;
            towerMap[v2][v1] = false;
            
            // 각 전력망에 연결된 송전탑의 개수
            cnt1 = bfs(towerMap, v1);
            cnt2 = bfs(towerMap, v2);
            answer = Math.min(answer, Math.abs(cnt1 - cnt2));
            
            // 끊어졌던 전선 다시 재연결
            towerMap[v1][v2] = true;
            towerMap[v2][v1] = true;
        }
        
        return answer;
    }
    
    int bfs(boolean[][] adjustMatrix, int start) {
        int count = 0;
        boolean[] visited = new boolean[adjustMatrix.length];
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.offer(start);
        visited[start] = true;
        count++;
        while (!bfsQueue.isEmpty()) {
            int curNode = bfsQueue.poll();
            for (int nodeNum = 1; nodeNum < adjustMatrix.length; nodeNum++) {
                if (visited[nodeNum]) continue;
                if (adjustMatrix[curNode][nodeNum]) {
                    count++;
                    visited[nodeNum] = true;
                    bfsQueue.offer(nodeNum);
                }
            }
        }
        return count;
    }
}
