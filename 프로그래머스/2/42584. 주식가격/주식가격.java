import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] prices) {
        final int N = prices.length;
        
        int[] answer = new int[N];
        
        for (int i = 0; i < N - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < N - 1; j++) {
                if (prices[i] <= prices[j]) count++;
                else break;
			}
            answer[i] = count;
        }
        
        return answer;
    }
}