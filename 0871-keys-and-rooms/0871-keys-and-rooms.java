class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);

        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int current) {
        visited[current] = true;
        for (int next : rooms.get(current)) {
            if (!visited[next]) {
                dfs(rooms, visited, next);
            }
        }
    }
}