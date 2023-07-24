class Solution {
    public double myPow(double x, long n) {
        if(n==0 || x==1)
            return 1;
        if(x==0)
            return 0;

        if(n<0)
            return myPow(1/x,Math.abs(n));

        return (n%2==0 ? myPow(x*x,n/2) : x*myPow(x*x,n/2));
    }
}
