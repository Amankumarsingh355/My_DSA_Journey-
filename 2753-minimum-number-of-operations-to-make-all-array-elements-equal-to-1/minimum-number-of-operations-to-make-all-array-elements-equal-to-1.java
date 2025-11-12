class Solution {
    public int minOperations(int[] nums) {
        int noOfOne = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1)
               noOfOne++;
        }
        if(noOfOne > 0)
          return nums.length - noOfOne;
        int currLen = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int currGcd = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                 currGcd = gcd(currGcd, nums[j]);
                if(currGcd == 1){
                    currLen = Math.min(currLen, j - i + nums.length - 1);
                    break;
                }
            }
        }
        return (currLen == Integer.MAX_VALUE) ? -1 : currLen;
    }
    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}