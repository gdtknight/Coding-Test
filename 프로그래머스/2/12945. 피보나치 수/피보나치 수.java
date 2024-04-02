class Solution {
    public int solution(int n) {
        int pre1 = 0;
        int pre2 = 1;
        int fibo = 0;
        int pre1Result = pre1 % 1234567;
        int pre2Result = pre2 % 1234567;
        int result = (pre1Result + pre2Result) % 1234567;
        
        for (int i = 2; i < n + 1 ; i++) {
            fibo = pre1 + pre2;
            result = (pre1Result + pre2Result) % 1234567;
            pre1Result = pre2Result;
            pre2Result = result;
            pre1 = pre2;
            pre2 = fibo;
        }
        return result;
    }
}