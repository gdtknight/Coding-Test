import java.util.Arrays;

class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        
        for (int row = 0; row <= n / 2; row++) {
            for (int col = row; col < n - row; col++) {
                answer[row][col] = num++;
            }
            
            for (int subrow = row + 1; subrow < n - 1 - row; subrow++) {
                answer[subrow][n - 1 - row] = num++;
            }
            
            for (int col = n - 1 - row; col > row; col--) {
                answer[n - 1 - row][col] = num++;
            }
            
            for (int subrow = n - 1 - row; subrow > row; subrow--) {
                answer[subrow][row] = num++;
            }
        }
        
        Arrays.stream(answer)
            .map(Arrays::toString)
            .forEach(System.out::println);
        
        return answer;
    }
}