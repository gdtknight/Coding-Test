import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerines) {
        int answer = 0;
        
        int[] arr = new int[10_000_001];
        
        for (int tangerine : tangerines) {
            arr[tangerine]++;
        }
        
        Arrays.sort(arr);
        
        for (int idx = arr.length - 1; idx >= 0; idx--) {
            if (k <= 0) {
                break;
            }
            
            k -= arr[idx];
            answer++;
        }
        
        return answer;
    }
}