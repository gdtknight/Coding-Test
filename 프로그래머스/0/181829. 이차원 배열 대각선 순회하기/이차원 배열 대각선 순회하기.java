class Solution {
    public int solution(int[][] board, final int K) {
        final int MAX_COL = board[0].length;
        
        int answer = 0;
        
        int maxColIdx = MAX_COL;
        
        for (int row = 0; row < board.length; row++) {
            maxColIdx = Math.min(K - row, MAX_COL - 1);
            
            for (int col = 0; col <= maxColIdx; col++) {
                answer += board[row][col];
            }
        }
        
        return answer;
    }
}