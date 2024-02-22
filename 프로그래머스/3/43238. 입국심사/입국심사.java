import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        int minTime = Integer.MAX_VALUE;
        int maxTime = 0;
        
        for (int time : times) {
            minTime = Math.min(minTime, time);
            maxTime = Math.max(maxTime, time);
        }
        
        long min = (long) n / (long) times.length * (long) minTime;
        long max = (long) n / (long) times.length * (long) maxTime;
        
        long mid;
        long people = 0;
        
        while(min < max) {
            mid = min + (max - min) / 2;
            people = 0;
            
            for (int time : times) {
                people += mid / (long)time;
            }
            
            if (people < n)   min = mid + 1;
            else              max = mid;
        }
        
        return min;
    }
}