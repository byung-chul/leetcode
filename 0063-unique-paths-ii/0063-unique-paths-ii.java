class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int y = obstacleGrid.length;
        int x = obstacleGrid[0].length;
        int[][] dp = new int[y][x];

        for (int i = 0; i < x; i++) {
            if (obstacleGrid[0][i] != 0) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 0; i < y; i++) {
            if (obstacleGrid[i][0] != 0) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int i = 1; i < y; i++) {
            for (int j = 1; j < x; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[y-1][x-1];
    }
}