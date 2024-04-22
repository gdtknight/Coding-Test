import java.util.Stack;

class Solution {
    public int solution(int[] ingredients) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for (int ingredient : ingredients) {
            stack.push(ingredient);
            
            while(4 <= stack.size()) {
                int ingredient4 = stack.pop();
                int ingredient3 = stack.pop();
                int ingredient2 = stack.pop();
                int ingredient1 = stack.pop();
                
                if (ingredient4 == 1
                    && ingredient3 == 3
                    && ingredient2 == 2
                    && ingredient1 == 1) {
                    answer++;
                } else {
                    stack.push(ingredient1);
                    stack.push(ingredient2);
                    stack.push(ingredient3);
                    stack.push(ingredient4);
                    break;
                }
            }
        }
        
        return answer;
    }
}