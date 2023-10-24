import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long min = (long)n / (long)times.length * (long)times[0];
        long max = (long)n / (long)times.length * (long)times[times.length - 1];
        
        while(min < max) {
            long mid = min + (max - min) / 2;
            
            long people = 0;
            for (int i = 0 ; i < times.length; i++) {
                people += mid / (long)times[i];
            }
            
            if (people < n) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
}