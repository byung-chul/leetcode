class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                q.add(new int[] {i, 0});
            }
            if (board[i][n-1] == 'O') {
                q.add(new int[] {i, n-1});
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                q.add(new int[] {0, i});
            }
            if (board[m-1][i] == 'O') {
                q.add(new int[] {m-1, i});
            }
        }

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            board[x][y] = 'A';
            for (int[] d : directions) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >=0 && nx <= m-1 && ny >= 0 && ny <= n-1 && board[nx][ny] == 'O') {
                    q.add(new int[] {nx, ny});
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}