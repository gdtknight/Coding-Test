// 크루스칼 알고리즘 필요 (서로소)
// 건설 비용이 낮은 순으로 정렬한 후, 간선 연결을 시작한다
// 각 노드의 부모가 일치하지 않으면 채택, 일치하면 pass
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(
            costs,
            (cost1, cost2) -> cost1[2] == cost2[2]
            				? cost1[0] == cost2[0]
            					? Integer.compare(cost1[1], cost2[1])
            					: Integer.compare(cost1[0], cost2[0])
            				: Integer.compare(cost1[2], cost2[2])
        );
        
        int answer = 0;
        int[] parent = new int[n];
        
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        
        
        for (int i = 0; i < costs.length; i++) {
            // 사이클을 구성하는 것이 아니라면
            if(findParent(parent, costs[i][0]) != findParent(parent, costs[i][1])) {
                answer += costs[i][2];
                union(parent, costs[i][0], costs[i][1]);
            }
        }
        
        return answer;
    }
    
    public int findParent(int[] parent, int node) {
        if (parent[node] == node)
            return node;
        
        return findParent(parent, parent[node]);
    }
    
    public void union(int[] parent, int node1, int node2) {
        int p1 = findParent(parent, node1);
        int p2 = findParent(parent, node2);
        
        if (p1 < p2)
            parent[p2] = p1;
        else        
            parent[p1] = p2;
    } 
}