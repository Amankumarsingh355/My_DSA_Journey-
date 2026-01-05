class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k == 1 ) return 0;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE; int i = 0 ;int j = i + k -1;
        while( j < nums.length){
                int temp = nums[j] - nums[i];
                if(temp < diff) diff = temp;
                i++;
                j++;
            }
        return diff;
    }
}