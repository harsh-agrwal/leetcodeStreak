You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
  Solution:
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length==2){
            return true;
            
        }
        int dy=(coordinates[1][1]-coordinates[0][1]);
        int dx=(coordinates[1][0]-coordinates[0][0]);
        for(int i=2;i<coordinates.length;i++){
            if(dy*(coordinates[i][0]-coordinates[1][0])!=dx*(coordinates[i][1]-coordinates[1][1]))
                return false;
        }
        return true;
    }
}
