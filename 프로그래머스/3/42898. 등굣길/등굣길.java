class Solution {
    public int solution(final int M, final int N, int[][] puddles) {
        int[][] countMap = new int[N + 1][M + 1];
        
        countMap[1][1] = 1;
        
        for (int[] p : puddles) {
            countMap[p[1]][p[0]] = -1;
        }
        
        for (int n = 1; n <= N; n++) {
            for (int m = 1; m <= M; m++) {
                if (countMap[n][m] == -1) continue;
                if (countMap[n - 1][m] > 0) countMap[n][m] = (countMap[n][m] + countMap[n - 1][m]) % 1_000_000_007;
                if (countMap[n][m - 1] > 0) countMap[n][m] = (countMap[n][m] + countMap[n][m - 1]) % 1_000_000_007;
            }
        }
        
        return countMap[N][M];
    }
}