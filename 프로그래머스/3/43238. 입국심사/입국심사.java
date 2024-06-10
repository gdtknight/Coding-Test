import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long min = 0;
        long max = Arrays.stream(times).max().orElse(Integer.MAX_VALUE) * (long) n;
        
        while(min <= max) {
            long mid = min + (max - min) / 2;
            
            long people = 0;
            
            for (int time : times) {
                people += (mid / time);
            }
            
            System.out.printf("Time : %d, People : %d%n", mid, people);
            
            if (people < n) min = mid + 1;
            else max = mid - 1;
        }
        
        return min;
    }
}