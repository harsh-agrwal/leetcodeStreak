Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
  Solution:
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        // Initialize dist matrix with maximum value for each cell
        // and add all 0's to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    visited[i][j] = true;
                    queue.offer(new int[] {i, j});
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol]) {
                    continue;
                }
                
                // Update distance if a shorter distance is found
                dist[newRow][newCol] = Math.min(dist[newRow][newCol], dist[row][col] + 1);
                visited[newRow][newCol] = true;
                queue.offer(new int[] {newRow, newCol});
            }
        }
        
        return dist;
    }
}
