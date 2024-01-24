import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        final int N = citations.length;
        
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        
        int answer = 0;
        int h = citations[N - 1];
        
        for (int idx = N - 1; 0 <= idx; idx--) {
            int paperCnt = N - idx;
            while (0 < idx && citations[idx - 1] < h) {
                if (h <= paperCnt) return h; 
                h--;
            }
        }
        
        h = citations[0];
        
        while (N < h) {
            if (h <= N) return h; 
            h--;
        }
        
        return h;
    }
}