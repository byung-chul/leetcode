class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, value);
            graph.get(b).put(a, 1 / value);
        }
        
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);
            results[i] = dfs(graph, c, d, new HashSet<>(), 1.0);
        }
        
        return results;
    }
    
    private double dfs(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited, double value) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }
        
        if (start.equals(end)) {
            return value;
        }
        
        visited.add(start);
        
        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(graph, neighbor.getKey(), end, visited, value * neighbor.getValue());
                if (result != -1.0) {
                    return result;
                }
            }
        }
        return -1.0;
    }
}