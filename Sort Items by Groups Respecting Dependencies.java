There are n items each belonging to zero or one of m groups where group[i] is the group that the i-th item belongs to and it's equal to -1 if the i-th item belongs to no group. The items and the groups are zero indexed. A group can have no item belonging to it.

Return a sorted list of the items such that:

The items that belong to the same group are next to each other in the sorted list.
There are some relations between these items where beforeItems[i] is a list containing all the items that should come before the i-th item in the sorted array (to the left of the i-th item).
Return any solution if there is more than one solution and return an empty list if there is no solution.
  Solution:
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, List<Integer>> groupItems = new HashMap<>();
        int groupId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = groupId;
                groupId++;
            }

            groupItems.computeIfAbsent(group[i], k -> new ArrayList<>()).add(i);
        }

        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        Map<Integer, Integer> itemIndegree = new HashMap<>();

        for (int v = 0; v < n; v++) {
            for (int u : beforeItems.get(v)) {
                if (group[u] == group[v]) {
                    itemGraph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
                    itemIndegree.put(v, itemIndegree.getOrDefault(v, 0) + 1);
                }
            }
        }

        Map<Integer, List<Integer>> sortedGroupItems = new HashMap<>();

        for (int groupIdKey : groupItems.keySet()) {
            List<Integer> sortedItems = topoSort(groupItems.get(groupIdKey), itemGraph, itemIndegree);

            if (sortedItems.size() != groupItems.get(groupIdKey).size()) {
                return new int[]{};
            }

            sortedGroupItems.put(groupIdKey, sortedItems);
        }

        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        Map<Integer, Integer> groupIndegree = new HashMap<>();

        for (int v = 0; v < n; v++) {
            for (int u : beforeItems.get(v)) {
                if (group[u] != group[v]) {
                    groupGraph.computeIfAbsent(group[u], k -> new ArrayList<>()).add(group[v]);
                    groupIndegree.put(group[v], groupIndegree.getOrDefault(group[v], 0) + 1);
                }
            }
        }

        Set<Integer> uniqueGroups = new HashSet<>();
        for (int g : group) {
            uniqueGroups.add(g);
        }

        List<Integer> sortedGroups = topoSort(uniqueGroups, groupGraph, groupIndegree);

        if (uniqueGroups.size() != sortedGroups.size()) {
            return new int[]{};
        }

        List<Integer> ans = new ArrayList<>();

        for (int sortedGroupId : sortedGroups) {
            ans.addAll(sortedGroupItems.get(sortedGroupId));
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> topoSort(Collection<Integer> nodes, Map<Integer, List<Integer>> graph, Map<Integer, Integer> inDegree) {
        Queue<Integer> queue = new LinkedList<>(nodes.stream().filter(node -> !inDegree.containsKey(node)).collect(Collectors.toList()));

        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            ans.add(curNode);

            if (graph.containsKey(curNode)) {
                for (int neighbor : graph.get(curNode)) {
                    inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                    if (inDegree.get(neighbor) == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        return ans;
    }
}
