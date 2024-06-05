import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        Comparator<int[]> comp = (r1, r2) -> Integer.compare(r1[1], r2[1]);
        
        Arrays.sort(routes, comp);
        
        int answer = 1;
        int camera = routes[0][1];
        
        for (int idx = 1; idx < routes.length; idx++) {
            if (camera < routes[idx][0]) {
                camera = routes[idx][1];
                answer++;
            }
        }
        
        return answer;
    }
}

