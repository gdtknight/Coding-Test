import java.util.StringTokenizer;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] start = new int[]{ 0, 0 };
        
        outer:
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    start = new int[]{i, j};
                    break outer;
                }
            }
        }
        
        
        loop:
        for (int idx = 0; idx < routes.length; idx++) {
            StringTokenizer st = new StringTokenizer(routes[idx], " ");
            String dir = st.nextToken();
            int len = Integer.parseInt(st.nextToken());
            
            int[] before = Arrays.copyOf(start, start.length);
            for (int i = 0; i < len; i++) {
                int[] after = Dir.valueOf(dir).move(before);
                if (after[0] == park.length || after[0] == -1 || after[1] == -1 || after[1] == park[0].length()) continue loop;
                if (park[after[0]].charAt(after[1]) == 'X') continue loop;
                before = after;
            }
            start = before;
        }
        
        return start;
    }
    
    enum Dir {
        N(new int[] {-1, 0}),
        S(new int[] {1, 0}),
        W(new int[] {0, -1}),
        E(new int[] {0, 1});
        
        private int[] dir;
        
        Dir(int[] dir) {
            this.dir = dir;
        }
        
        public int[] move(int[] before) {
            int[] after = new int[2];
            after[0] = before[0] + dir[0];
            after[1] = before[1] + dir[1];
            
            return after;
        }
    }
}