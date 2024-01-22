class Solution {
    public int solution(final int N) {
        int answer = 0;
        
        if (N == 1) return 1;
        
        int sum = 1;
        int min = 1;
        
        int sIdx = 1, eIdx = 1;
        
        for (int num = 2; num <= N; num++) {
            sum += num;
            
            if (sum == N) {
                answer++; 
                continue;
            } 
            
            while (sum > N) {
                sum -= min++;
            }
            
            if (sum == N) {
                answer++; 
            } 
        }
        
        
        return answer;
    }
}