import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        int[] largeIdx = new int[numbers.length];
        int[] answer = new int[numbers.length];
        
        answer[numbers.length - 1] = -1;
        largeIdx[numbers.length - 1] = -1;
        
        out :
        for (int idx = numbers.length - 2; idx >= 0; idx--) {
            int nextIdx = idx + 1;
            
            while(-1 < nextIdx && nextIdx < numbers.length) {
                if (numbers[idx] < numbers[nextIdx]) {
                    answer[idx] = numbers[nextIdx];
                    largeIdx[idx] = nextIdx;
                    continue out;
                } else if (numbers[idx] == numbers[nextIdx]) {
                    answer[idx] = answer[nextIdx];
                    largeIdx[idx] = largeIdx[nextIdx];
                    continue out;
                } else {
                    nextIdx = largeIdx[nextIdx];
                }
            }
            
            answer[idx] = -1;
            largeIdx[idx] = -1;
        }
        
        return answer;
    }
}