import java.util.Arrays;
class Solution {
    private int[] dp = new int[51];
    public int minExtraChar(String s, String[] dictionary) {
        Arrays.fill(dp, -1);
        return minExtraCharHelper(s, dictionary, 0);
    }
    private int minExtraCharHelper(String s, String[] dictionary, int i) {
        if (i == s.length()) {
            return 0;
        }
        if (dp[i] == -1) {
            dp[i] = 1 + minExtraCharHelper(s, dictionary, i + 1);
            for (String w : dictionary) {
                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = Math.min(dp[i], minExtraCharHelper(s, dictionary, i + w.length()));
                }
            }
        }
        return dp[i];
    }
}
