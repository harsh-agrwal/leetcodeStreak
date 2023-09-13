public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length; // Get the number of children
        
        int[] candies = new int[n]; // Initialize an array to store the number of candies for each child
        
        // First pass: Check ratings from left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i] && candies[i - 1] >= candies[i]) {
                // If the current child has a higher rating and fewer or equal candies than the previous child,
                // give them one more candy than the previous child
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Second pass: Check ratings from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i] && candies[i + 1] >= candies[i]) {
                // If the current child has a higher rating and fewer or equal candies than the next child,
                // give them one more candy than the next child
                candies[i] = candies[i + 1] + 1;
            }
        }
        
        int totalCandies = 0;
        
        // Calculate the total number of candies needed
        for (int i = 0; i < n; i++) {
            totalCandies += candies[i] + 1;
        }
        
        return totalCandies;
    }
}
