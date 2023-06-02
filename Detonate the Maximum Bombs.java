class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int maxBombs = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (Math.pow(bombs[i][2], 2) >= Math.pow(bombs[i][0] - bombs[j][0], 2) + Math.pow(bombs[i][1] - bombs[j][1], 2)) {
                    List<Integer> neighbors = graph.getOrDefault(i, new ArrayList<>());
                    neighbors.add(j);
                    graph.put(i, neighbors);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            dfs(i, visited, graph);
            maxBombs = Math.max(maxBombs, visited.size());
        }
        return maxBombs;
    }
    private void dfs(int node, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
        for (int child : neighbors) {
            if (!visited.contains(child)) {
                visited.add(child);
                dfs(child, visited, graph);
            }
        }
    }
}
