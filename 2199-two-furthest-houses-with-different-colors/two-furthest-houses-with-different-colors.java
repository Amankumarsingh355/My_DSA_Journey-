class Solution {
    public int maxDistance(int[] colors) {
        int max=0,l=0,r=colors.length-1;
        while(l<=r)
        {
            if(colors[l]!=colors[r])
            max=Math.max(max,r-l);
            r--;
        }
        l=0;r=colors.length-1;
        while(l<=r)
        {
            if(colors[l]!=colors[r])
            max=Math.max(max,r-l);
            l++;
        }
        return max;
    }
}