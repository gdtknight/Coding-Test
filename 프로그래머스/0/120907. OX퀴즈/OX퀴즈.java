import java.util.Arrays;

class Solution {
    public String[] solution(String[] quiz) {
        return Arrays.stream(quiz)
            .map(expr -> expr.split(" = "))
            .map(args -> {
                int leftResult = 0;
                int rightResult = Integer.parseInt(args[1]);
                
                String[] leftArgs = args[0].split(" [+-] ");
                if (args[0].contains(" + ")) {
                    leftResult = Integer.parseInt(leftArgs[0]) + Integer.parseInt(leftArgs[1]);
                } else if (args[0].contains(" - ")) {
                    leftResult = Integer.parseInt(leftArgs[0]) - Integer.parseInt(leftArgs[1]);
                }
                
                if (leftResult == rightResult) {
                    return "O";
                } 
                
                return "X";
            })
            .toArray(String[]::new);
    }
}