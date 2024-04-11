import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        final int NUM_OF_WORKS = progresses.length;
        
        int[] days = new int[NUM_OF_WORKS];
        
        for (int idx = 0; idx < NUM_OF_WORKS; idx++) {
            days[idx] = Double.valueOf(
                Math.ceil((100.0 - progresses[idx]) / speeds[idx]))
                .intValue();
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        
        int lastIdx = 0;
        
        for (int idx = 1; idx < NUM_OF_WORKS; idx++) {
            if (days[lastIdx] < days[idx]) {
                stack.push(1);
                lastIdx = idx;
            } else {
                stack.push(stack.pop() + 1);
            }
        }
        
        return stack.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}