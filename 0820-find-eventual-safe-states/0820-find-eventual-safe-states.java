class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, state)) {
                result.add(i);
            }
        }
        Collections.sort(result);
        return result;
    }
    private boolean dfs(int i, int[][] graph, int[] state) {
        if (state[i] != 0) {
            return state[i] == 2;
        }
        state[i] = 1;
        for (int neighbor : graph[i]) {
            if (state[neighbor] == 2) {
                continue;
            }
            if (state[neighbor] == 1 || !dfs(neighbor, graph, state)) {
                return false;
            }
        }
        state[i] = 2;
        return true;
    }
}