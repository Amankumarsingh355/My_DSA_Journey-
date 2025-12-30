class Solution {
    public int minStartValue(int[] nums) {
        int len=nums.length;
        int[] preFix=new int[len];
        int minStartValue=1;
        for(int i=0;i<len;i++){
            if(i==0){
                preFix[i]=minStartValue+nums[i];
            }
            else{
                preFix[i]=preFix[i-1]+nums[i];
            }
            if(preFix[i]<1){
                int toBeIncreased=1-preFix[i];
                preFix[i]+=toBeIncreased;
                minStartValue+=toBeIncreased;
            }
        }
        return minStartValue;
    }
}