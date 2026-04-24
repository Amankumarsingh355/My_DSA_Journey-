class Solution {
    public int furthestDistanceFromOrigin(String m) {
        int in=0;
        int cnt=0;
        int n=m.length();
        for(int i=0;i<n;i++)
        {
                if(m.charAt(i)=='L')
                {
                    in=in+1;
                }
                else if(m.charAt(i)=='R')
                {
                    in=in-1;
                }
                else
                {
                    cnt++;
                }
        }
        if(in<0)
        {
            in=Math.abs(in-cnt);
        }
        else{
            in=Math.abs(in+cnt);
        }
        return in;
    }
}