import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> charStack = new Stack<>();
        char[] chars = s.toCharArray();
        
        int answer = 0;
        
        out :
        for (int x = 0; x < chars.length; x++) {
            for (int idx = x; idx < x + chars.length; idx++) {
                char c = chars[(idx + chars.length) % chars.length];
                if (c == '[' || c == '{' || c == '(') {
                    charStack.push(c);
                    continue;
                }
                
                if (c == ']' && !charStack.isEmpty() && charStack.peek() == '[') {
                    charStack.pop();
                } else if (c == '}' && !charStack.isEmpty() && charStack.peek() == '{') {
                    charStack.pop();
                } else if (c == ')' && !charStack.isEmpty() && charStack.peek() == '(') {
                    charStack.pop();
                } else if (c == ']' || c == '}' || c == ')') {
                    charStack.clear();
                    continue out;
                }
            }
            
            if (charStack.isEmpty()) answer++;
            charStack.clear();
        }
        
        return answer;
    }
}