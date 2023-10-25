public class Solution {
    public int kthGrammar(int n, int k) {
        boolean areValuesSame = true;
        n = (int) Math.pow(2, n - 1);
        while (n != 1) {
            n /= 2;
            if (k > n) {
                k -= n;
                areValuesSame = !areValuesSame;
            }
        }
        return (areValuesSame ? 0 : 1);
    }
}
