class Solution {
    public long solution(int n) {
        long[] arr = new long[n + 1];
        
        arr[0] = 1;
        
        for (int idx = 0; idx <= n; idx++) {
            if (idx + 1 <= n) arr[idx + 1] = (arr[idx + 1] + arr[idx]) % 1234567;
            if (idx + 2 <= n) arr[idx + 2] = (arr[idx + 2] + arr[idx]) % 1234567;
        }
        
        return arr[n] % 1234567;
    }
}