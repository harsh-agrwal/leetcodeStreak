Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
  Solution:
class Solution {
    public int diagonalSum(int[][] mat) {
      int n = mat.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += mat[i][i] + mat[i][n - i - 1];
        }
        if (n % 2 == 1) {
            result -= mat[n / 2][n / 2];
        }
        return result;   
    }
}
