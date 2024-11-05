class Solution {
    public int orangesRotting(int[][] grid) {
        int oranges = 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = -1;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    oranges++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }
        if (oranges == 0) {
            return 0;
        }
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int cx = current[0];
                int cy = current[1];

                for (int[] direction : directions) {
                    int nx = cx + direction[0];
                    int ny = cy + direction[1];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        oranges--;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return oranges == 0 ? count : -1;
        
    }
}