class Solution{
    public int minRemoval(int[] nums, int k){
        Arrays.sort(nums);
        int n= nums.length;
        int left =0;
        int maxkeep=1;
        for (int right=0;right<n;right++){
            while((long) nums[right]>(long) nums[left]*k ){
                left++;

            }
            maxkeep=Math.max(maxkeep,right- left+1);
        }
        return n -maxkeep;
    }
}