class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev=cost[0],prev2=0,current;
        for(int i=1;i<cost.length;i++){
            current=Math.min(prev2+cost[i],prev+cost[i]);
            prev2=prev;
            prev=current;
        }
        return Math.min(prev,prev2);
    }
}
