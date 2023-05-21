class Solution {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        boolean breakEnable = false;
        for(int i = 0; i < n ; i++){
            if(breakEnable) break;
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    formGraph(grid , q ,i , j ,  n ,vis , dx , dy);
                    breakEnable = true;
                    break;
                }
            }
        }
        int minimumSteps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.remove();
                for(int i = 0 ; i < 4 ; i++){
                    int newX = curr[0] + dx[i];
                    int newY = curr[1] + dy[i];
                    if(isValid(newX,newY,n)){
                        if(!vis[newX][newY] && grid[newX ][newY] == 1){
                            return minimumSteps;
                        }
                        else if(!vis[newX][newY] && grid[newX][newY] == 0){
                            q.add(new int[]{newX,newY});
                            vis[newX][newY] = true;
                        }
                    } 
                }
            }
            minimumSteps++;
        }
        return -1;
    }
    public boolean isValid(int i , int j , int n){
        if(i < 0 || j<0 || i >=n || j >= n) return false;
        return true;
    }
    public void formGraph(int[][] grid , Queue<int[]> q , int x , int y , int n , boolean[][] vis , int[] dx , int[] dy){
        if(!isValid(x,y,n)) return;
        if(!vis[x][y] && grid[x][y] == 1){
            q.add(new int[] {x,y});
        }else{
            return;
        }
        vis[x][y] = true;
        for(int i = 0 ; i < 4 ; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            formGraph(grid , q, newX,newY,n,vis,dx,dy);
        }
    }
}
