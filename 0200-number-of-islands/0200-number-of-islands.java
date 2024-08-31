class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int numbers = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numbers++;
                    bfs(grid, i, j);
                }
            }
        }
        return numbers;
    }
    private void bfs(char[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        grid[x][y] = '0';
        q.add(new int[] {x, y});

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for (int[] direction : directions) {
                int nx = cx + direction[0];
                int ny = cy + direction[1];

                if (nx >= 0 && nx <= m - 1 && ny >= 0 && ny <= n - 1 && grid[nx][ny] == '1') {
                    q.add(new int[] {nx, ny});
                    grid[nx][ny] = '0';
                }
            }
        }
    }
}