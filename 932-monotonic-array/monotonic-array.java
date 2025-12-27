class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length <= 2) return true;
        boolean flag = true;
        int i = 0;
        for(i = 0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]) continue;
            else if(nums[i] > nums[i+1]){
                 flag = false;
                 break;
            }
            else if(nums[i] < nums[i+1]){
                 flag = true;
                 break;
            }
        }
        if(i == nums.length && flag == true) return true;
        if(flag){
            for(int j = 1;j<nums.length-1;j++){
                if(nums[j] > nums[j+1]) return false;
            }
            return true;
        }
        else{
            for(int j = 1;j<nums.length-1;j++){
                if(nums[j] < nums[j+1]) return false;
            }
            return true;
        }
    }
}