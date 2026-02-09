import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> mainBelt = new Stack<>();
        Stack<Integer> secondBelt = new Stack<>();
        
        for (int num = order.length; num > 0; num--)
            mainBelt.push(num);
        
        for (int target: order) {
            if (!mainBelt.isEmpty() && mainBelt.peek() == target) {
                // System.out.printf("[mainBelt] Target pop : %d\n", target);
                answer++;
                mainBelt.pop();
                continue ;
            }
            if (!secondBelt.isEmpty() && secondBelt.peek() == target) {
                // System.out.printf("[secondBelt] Target pop : %d\n", target);
                answer++;
                secondBelt.pop();
                continue ;
            }
            // if (!mainBelt.isEmpty() && !secondBelt.isEmpty())
                // break ;
            if (mainBelt.isEmpty() && !secondBelt.isEmpty() && secondBelt.peek() != target)
                break ;
            // System.out.printf("Target: %d\n", target);
            // System.out.printf("MainBelt: %d\n", mainBelt.peek());
            while (!mainBelt.isEmpty() && mainBelt.peek() != target) {
                secondBelt.push(mainBelt.pop());
            }
            while (!mainBelt.isEmpty() && mainBelt.peek() == target) {
            	answer++;
                mainBelt.pop();
            }
            // System.out.println(mainBelt);
            // System.out.println(secondBelt);
        }
        
        return answer;
    }
}