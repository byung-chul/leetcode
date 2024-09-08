class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] squares = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                char current = board[i][j];
                if (rows[i].contains(current)) {
                    return false;
                }
                rows[i].add(current);

                if (cols[j].contains(current)) {
                    return false;
                }
                cols[j].add(current);

                int box = (i / 3) * 3 + (j / 3);
                if (squares[box].contains(current)) {
                    return false;
                }
                squares[box].add(current);
            }
        }
        return true;
    }
}