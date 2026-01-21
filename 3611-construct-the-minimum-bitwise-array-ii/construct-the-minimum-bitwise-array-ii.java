class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans=new int[nums.size()];
        for(int i=0; i<nums.size(); i++) {
            int num=nums.get(i);
            if(num==2) {
                ans[i]=-1;
                continue;
            }
            int numConsecOnes=0;
            while(num>0) {
                int rem = num % 2;
                if(rem==0) 
                    break;
                num /= 2;
                numConsecOnes++;
            }
            ans[i]=nums.get(i) - (int)Math.pow(2, numConsecOnes-1);
        }
        return ans;
    }
}