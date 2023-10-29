class CheckBit
{
    static boolean checkKthBit(int n, int k)
    {
        for(int i=1;i<=k;i++)
        {  n=n/2;
        }
            if(n%2==1)
            {
                return true;
            }
        return false;
    }
}
