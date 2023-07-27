You have n computers. You are given the integer n and a 0-indexed integer array batteries where the ith battery can run a computer for batteries[i] minutes. You are interested in running all n computers simultaneously using the given batteries.

Initially, you can insert at most one battery into each computer. After that and at any integer time moment, you can remove a battery from a computer and insert another battery any number of times. The inserted battery can be a totally new battery or a battery from another computer. You may assume that the removing and inserting processes take no time.

Note that the batteries cannot be recharged.

Return the maximum number of minutes you can run all the n computers simultaneously.
  Solution:
public class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sumPower = 0;
        for (int power : batteries)
            sumPower += power;
        long left = 1, right = sumPower / n;
        
        while (left < right){
            long time = (left+right+1) / 2;
            if (check(batteries, n, time))
                left = time;
            else
                right = time - 1;
        }
        return left;
    }
    
    public boolean check(int [] B, int n, long time){
        long sum = 0;
        for(int battery: B){
            sum+=Math.min(battery, time);
        }
        return (sum>=(long)time*n);
    }
}
