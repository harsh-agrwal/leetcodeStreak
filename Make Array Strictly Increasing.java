

class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int n = arr1.length;

        Arrays.sort(arr2);
        List<Integer> uniqueArr2 = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            if (i + 1 < arr2.length && arr2[i] == arr2[i + 1]) {
                continue;
            }
            uniqueArr2.add(arr2[i]);
        }
        int[] newArr2 = new int[uniqueArr2.size()];
        for (int i = 0; i < uniqueArr2.size(); i++) {
            newArr2[i] = uniqueArr2.get(i);
        }
        arr2 = newArr2;

        int[] newArr1 = new int[n + 2];
        for (int i = 0; i < n; i++) {
            newArr1[i + 1] = arr1[i];
        }
        newArr1[n + 1] = Integer.MAX_VALUE;
        newArr1[0] = Integer.MIN_VALUE;
        arr1 = newArr1;

        int[] dp = new int[n + 2];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n + 2; i++) {
            for (int j = 0; j < i; j++) {
                if (arr1[j] < arr1[i] && dp[j] != Integer.MAX_VALUE) {
                    int change = check(arr1, arr2, j, i);
                    if (change >= 0) {
                        dp[i] = Math.min(dp[i], dp[j] + change);
                    }
                }
            }
        }
        return dp[n + 1] == Integer.MAX_VALUE ? -1 : dp[n + 1];
    }

    private int check(int[] arr1, int[] arr2, int start, int end) {
        if (start + 1 == end) {
            return 0;
        }
        int min = arr1[start];
        int max = arr1[end];
        int idx = Arrays.binarySearch(arr2, min);
        if (idx < 0) {
            idx = -idx - 1;
        } else {
            idx = idx + 1;
        }

        int maxCount = end - start - 1;
        int endIdx = idx + maxCount - 1;
        if (endIdx < arr2.length && arr2[endIdx] < max) {
            return maxCount;
        } else {
            return -1;
        }
    }
}
