A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

Return the number of minutes needed to inform all the employees about the urgent news.
  Solution:
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] arr = new ArrayList[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                arr[manager[i]].add(i);
            }
        }

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(headID, informTime[headID]));

        while (!q.isEmpty()) {
            int si = q.size();

            for (int i = 0; i < si; i++) {
                Pair<Integer, Integer> t = q.poll();

                for (int x : arr[t.getKey()]) {
                    if (informTime[x] == 0) {
                        ans = Math.max(ans, t.getValue());
                    } else {
                        q.offer(new Pair<>(x, t.getValue() + informTime[x]));
                    }
                }
            }
        }

        return ans;
    }
}
