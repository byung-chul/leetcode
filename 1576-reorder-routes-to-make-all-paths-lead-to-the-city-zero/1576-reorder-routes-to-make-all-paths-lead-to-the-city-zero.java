class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph.get(from).add(new int[]{to, 1});
            graph.get(to).add(new int[]{from, 0});
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(0);
        visited[0] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int currentCity = q.poll();
            for (int[] nearCity : graph.get(currentCity)) {
                int next = nearCity[0];
                int needToChange = nearCity[1];

                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    count += needToChange;
                }
            }
        }
        return count;
    }
}