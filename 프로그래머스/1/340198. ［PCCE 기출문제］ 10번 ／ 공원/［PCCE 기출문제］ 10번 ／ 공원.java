import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int[][] dp = new int[park.length][park[0].length];
        int max_size = 0;
        
        for (int row = 0; row < park.length; row++) {
            for (int col = 0; col < park[0].length; col++) {
                if (!park[row][col].equals("-1"))
                    continue;
                if (row == 0 || col == 0)
                    dp[row][col] = 1;
                else
                    dp[row][col] = Math.min(dp[row - 1][col - 1], Math.min(dp[row - 1][col],dp[row][col - 1])) + 1;
                if (dp[row][col] > max_size)
                    max_size = dp[row][col];
            }
        }
        
        Arrays.sort(mats);
        for (int idx = mats.length - 1; idx >= 0; idx--) {
            if (mats[idx] > max_size)
                continue;
            return mats[idx];
        }
        
        return (-1);
    }
}