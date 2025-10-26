class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0]=nums[0];
        int len=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>dp[len-1]){
                dp[len]=nums[i];
                len++;
            }
            else{
                int idx = helper(dp,nums[i],len-1);
                dp[idx]=nums[i];
            }
        }
        return len;
    }
    public int helper(int dp[], int item,int len){
        int ans=0;
        int low=0;
        int high=len;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(dp[mid]>=item){
                ans = mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}