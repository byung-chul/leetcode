class Solution {
    private int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];

        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }

        return board;
    }
    private void dfs(char[][] board, int x, int y) {
        int mines = findMine(board, x, y);
        if (mines > 0) {
            board[x][y] = (char) (mines + '0');
        } else {
            board[x][y] = 'B';
            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length 
                && board[nx][ny] == 'E') {
                    dfs(board, nx, ny);
                }
            }
        }
    }
    private int findMine(char[][] board, int x, int y) {
        int mine = 0;
        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length 
            && board[nx][ny] == 'M') {
                mine++;
            }
        }
        return mine;
    }
}