class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{ 0, sequence.length - 1 };
        int startIdx = 0;
        int sum = 0;
        
        for (int idx = 0; idx < sequence.length; idx++) {
            sum += sequence[idx];
            
            while (sum > k) {
                sum -= sequence[startIdx++];
            }
            
            // System.out.println("[" + startIdx + ", " + idx + "] = " + sum);
            
            if (sum == k && (idx - startIdx) < (answer[1] - answer[0])) {
                answer[0] = startIdx;
                answer[1] = idx;
            }
        }
        
        return answer;
    }
}