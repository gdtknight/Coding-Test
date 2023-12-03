import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        
        Stack<Integer> stack = new Stack<>();
        
        for (int move : moves) {
            int yPos = 0;
            
            while(yPos < N) {
                if (board[yPos][move - 1] == 0) {
                    yPos++;
                    continue; 
                } 
                
                if (!stack.isEmpty() && stack.peek() == board[yPos][move - 1]) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(board[yPos][move - 1]);
                } 
                
                board[yPos][move - 1] = 0;
                break;
            }
        }
        
        return answer;
    }
}