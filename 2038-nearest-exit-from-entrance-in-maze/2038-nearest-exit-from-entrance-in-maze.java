class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 0;

        queue.offer(new int[]{entrance[0], entrance[1], 0});
        visited[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int step = current[2];

            if ((cx == 0 || cx == m - 1 || cy == 0 || cy == n - 1) && (cx != entrance[0] || cy != entrance[1])) {
                return step;
            }

            for (int[] direction : directions) {
                int nx = cx + direction[0];
                int ny = cy + direction[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && maze[nx][ny] != '+') {
                    queue.offer(new int[]{nx, ny, step + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}