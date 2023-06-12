You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
Solution:

class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<String> ranges = new ArrayList<>();
        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    ranges.add(Integer.toString(start));
                } else {
                    ranges.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }
        }

        // Handle the last range
        if (start == nums[nums.length - 1]) {
            ranges.add(Integer.toString(start));
        } else {
            ranges.add(start + "->" + nums[nums.length - 1]);
        }

        return ranges;
    }
}
