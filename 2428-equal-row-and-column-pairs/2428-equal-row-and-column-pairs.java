class Solution {
    public int equalPairs(int[][] grid) {
        int size = grid.length;
        int count = 0;
        Map<String, Integer> listMap = new HashMap<>();

        for (int[] row : grid) {
            String rowString = Arrays.toString(row);
            listMap.put(rowString, listMap.getOrDefault(rowString, 0) + 1);
        }

        for (int i = 0; i < size; i++) {
            StringBuilder currentColumnBuilder = new StringBuilder();
            currentColumnBuilder.append("[");
            for (int j = 0; j < size; j++) {
                currentColumnBuilder.append(grid[j][i]).append(", ");
            }
            
            currentColumnBuilder.setLength(currentColumnBuilder.length() - 2);
            currentColumnBuilder.append("]");
            String column = currentColumnBuilder.toString();
            count += listMap.getOrDefault(column, 0);
        }

        return count;
    }
}