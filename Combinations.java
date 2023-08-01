Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.
  Solution:
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            findUsingBackTracking(i, k, n, list, set);
        }
        return new ArrayList<>(set);
    }

    private void findUsingBackTracking(int curr, int k, int n, List<Integer> list, Set<List<Integer>> set) {
        if (list.size() > k) {
            return;
        }

        list.add(curr);

        if (list.size() == k) {
            set.add(new ArrayList<>(list));
        }

        for (int i = curr + 1; i <= n; i++) {
            findUsingBackTracking(i, k, n, list, set);
        }
        list.remove(list.size() - 1);
    }
}
