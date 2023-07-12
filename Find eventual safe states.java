There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
  Solution:
  class Solution {
    public boolean dfs(List<List<Integer>> adj, int src, boolean[] vis, boolean[] recst) {
        vis[src] = true;
        recst[src] = true;
        for (int x : adj.get(src)) {
            if (!vis[x] && dfs(adj, x, vis, recst)) {
                return true;
            } else if (recst[x]) {
                return true;
            }
        }
        recst[src] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                list.add(graph[i][j]);
            }
            adj.add(list);
        }
        boolean[] vis = new boolean[n];
        boolean[] recst = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis, recst);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < recst.length; i++) {
            if (!recst[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
