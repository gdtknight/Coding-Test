import java.util.Arrays;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        final int ROWS = rows + 1;
        final int COLS = columns + 1;
        
        int[][] matrix = new int[ROWS][COLS];
        
        int count = 1;
        
        for (int row = 1; row < ROWS; row++) {
            for (int col = 1; col < COLS; col++) {
                matrix[row][col] = count;
                count++;
            }
        }
        
        int[] answer = new int[queries.length];
        
        for (int idx = 0; idx < queries.length; idx++) {
            int r1 = queries[idx][0];
            int c1 = queries[idx][1];
            int r2 = queries[idx][2];
            int c2 = queries[idx][3];
            
            // 왼쪽 테두리
            int temp = matrix[r1][c1];
            int min = temp;
            
            for (int row = r1; row < r2; row++) {
                matrix[row][c1] = matrix[row + 1][c1];
                
                if (matrix[row][c1] < min) {
                    min = matrix[row][c1];
                }
            }
            
            // 아래쪽 테두리
            for (int col = c1; col < c2; col++) {
                matrix[r2][col] = matrix[r2][col + 1];
                
                if (matrix[r2][col] < min) {
                    min = matrix[r2][col]; 
                } 
            }
            
            // 오른쪽 테두리
            for (int row = r2; row > r1; row--) {
                matrix[row][c2] = matrix[row - 1][c2];
                
                if (matrix[row][c2] < min) {
                    min = matrix[row][c2];
                }
            }
            
            // 상단 테두리
            for (int col = c2; col > c1 + 1; col--) {
                matrix[r1][col] = matrix[r1][col - 1];
                
                if (matrix[r1][col] < min) {
                    min = matrix[r1][col];
                }
            }
            
            // 첫번째 시작점
            matrix[r1][c1 + 1] = temp;
            
            answer[idx] = min;
        }
        
        return answer;
    }
}