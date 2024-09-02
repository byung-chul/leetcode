class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) {
            return image;
        }
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        q.add(new int[] {sr, sc});
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for (int[] direction: directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && image[nx][ny] == original) {
                    q.add(new int[] {nx, ny});
                    image[nx][ny] = color;
                }
            }
        }

        return image;
    }
}