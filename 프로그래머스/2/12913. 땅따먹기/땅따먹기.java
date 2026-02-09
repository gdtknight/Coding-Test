class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];

        for (int col = 0; col < land[0].length; col++)
            dp[0][col] = land[0][col];
        
        for (int row = 1; row < land.length; row++) {
            for (int col = 0; col < land[0].length; col++) {
                int prevMax = 0;
                for (int prevCol = 0; prevCol < land[0].length; prevCol++) {
                    if (prevCol == col)
                        continue ;
                    if (prevMax < dp[row - 1][prevCol])
                        prevMax = dp[row - 1][prevCol];
                }
                dp[row][col] = prevMax + land[row][col];
            }
        }

        return Math.max(
            Math.max(dp[land.length - 1][0], dp[land.length - 1][1]),
            Math.max(dp[land.length - 1][2], dp[land.length - 1][3])
        );
    }
}