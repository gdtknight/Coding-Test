import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Integer> stack = new Stack<>();
        String[] args = s.split(" ");
        
        for (String arg : args) {
            if ("Z".equals(arg) && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(arg));
            }
        }
        
        return stack.stream()
            .reduce((n1, n2) -> n1 + n2)
            .orElse(0);
    }
}