import java.util.Arrays;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int idx = 0 ; idx < quiz.length; idx++) {
            String[] args = quiz[idx].split("=");
            
            args[0] = args[0].trim();
            args[1] = args[1].trim();
            
            String[] leftArgs = args[0].split(" [+-] ");
            
            int leftResult = 0;
            if (args[0].contains("+")) {
                leftResult = Integer.parseInt(leftArgs[0]) + Integer.parseInt(leftArgs[1]);
            } else if (args[0].contains("-")) {
                leftResult = Integer.parseInt(leftArgs[0]) - Integer.parseInt(leftArgs[1]);
            } else {
                throw new RuntimeException("Fxxk");  
            }
            
            int rightResult = Integer.parseInt(args[1]);
            
            if (leftResult == rightResult) answer[idx] = "O";
            else answer[idx] = "X";
        }
        
        return answer;
    }
}