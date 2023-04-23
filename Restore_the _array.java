A program was supposed to print an array of integers. The program forgot to print whitespaces and the array is printed as a string of digits s and all we know is that all integers in the array were in the range [1, k] and there are no leading zeros in the array.

Given the string s and the integer k, return the number of the possible arrays that can be printed as s using the mentioned program. Since the answer may be very large, return it modulo 109 + 7.
  Solution:
class Solution {
    public int numberOfArrays(String s, int k) {
        int mod =  1_000_000_007;
        int n =  s.length();
        int dp[] =  new int[n+1];
        dp[0] =  1;
        
        // dp[i] =  count of  possible arrays for i length string
        
        for(int i=1;i<=n;i++){ 
            int ans = 0;
            int start =  n-i;// reading string from end 
            
            // taking min beacuse we can have maximum 9 digit number 
            for(int j = start ; j < Math.min(n,start+9) ;j++ ){ 
                
                String num =  s.substring(start,j+1);
                
                if(num.charAt(0)=='0') continue;
                
               int val =  Integer.parseInt(num);
                
                if(val<=k){ // if numver is valid 
                    ans = (ans + dp[n-j-1])%mod;
                }
                else{
                    // if current number is greater than k  , then number formed after this number
                    // also greater than k , so break loop
                    break;
                }
                
            }
            
            dp[i] = ans%mod;
            
        }
        
        return dp[s.length()];// return answer for n len string 
    }
}
