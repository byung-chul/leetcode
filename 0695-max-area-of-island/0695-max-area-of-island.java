class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 1;
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int current = dfs(grid, m, n, i, j);
                    max = Math.max(current, max);
                }
            }
        }
        return max;
    }
    
    private int dfs(int[][] grid, int m, int n, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) return 0;

        grid[x][y] = 0;
        
        int current = 1;
        current += dfs(grid, m, n, x - 1, y);
        current += dfs(grid, m, n, x + 1, y);
        current += dfs(grid, m, n, x, y - 1);
        current += dfs(grid, m, n, x, y + 1);
        return current;
    }
}