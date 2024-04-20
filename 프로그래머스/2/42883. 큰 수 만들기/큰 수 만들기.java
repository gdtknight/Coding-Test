import java.util.Iterator;
import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> charStack = new Stack<>();
        
        for (int idx = 0; idx < number.length(); idx++) {
            while(!charStack.isEmpty() && charStack.peek() < number.charAt(idx) && 0 < k) {
                charStack.pop();
                k--;
            }
            
            charStack.push(number.charAt(idx));
        }
        
        while(0 < k--) {
            charStack.pop();
        }
        
        Iterator<Character> it = charStack.iterator();
        StringBuilder answerBuilder = new StringBuilder();
        
        while(it.hasNext()) {
            answerBuilder.append(it.next());
        }
        
        return answerBuilder.toString();
    }
}