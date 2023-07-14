Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.
  
Solution:
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> m= new HashMap<>();
        int max=0;
        for(int i=0; i<arr.length;i++){
            int c=arr[i];
            if(m.containsKey(c-difference))
            m.put(c,m.get(c-difference)+1);
            else
            m.put(c, 1);
            max=Math.max(max,m.get(c));
        }
        return max;
    }
}
