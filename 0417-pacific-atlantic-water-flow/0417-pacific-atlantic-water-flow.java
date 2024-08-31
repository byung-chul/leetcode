class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            atlantic[i][n-1] = true;
            pacificQ.add(new int[] {i, 0});
            atlanticQ.add(new int[] {i, n-1});
        }
        for (int i = 0; i < n; i++) {
            pacific[0][i] = true;
            atlantic[m-1][i] = true;
            pacificQ.add(new int[] {0, i});
            atlanticQ.add(new int[] {m-1, i});
        }
        bfs(heights, pacific, pacificQ);
        bfs(heights, atlantic, atlanticQ);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void bfs(int[][] heights, boolean[][] visited, Queue<int[]> q){
        int m = heights.length;
        int n = heights[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for (int[] direction : directions) {
                int nx = cx + direction[0];
                int ny = cy + direction[1];

                if (nx >= 0 && nx < m 
                && ny >= 0 && ny < n
                && !visited[nx][ny] 
                && heights[nx][ny] >= heights[cx][cy]) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }
    }
}