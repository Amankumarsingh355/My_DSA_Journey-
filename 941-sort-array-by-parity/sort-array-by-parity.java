class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int [] arr=new int[nums.length];
        int j=0;
        int j1=nums.length-1;
     for(int i=0;i<nums.length;i++){
        if(nums[i]%2==0){
           arr[j]=nums[i];
           j++;
        }
        else{
         arr[j1]=nums[i];
         j1--;
        }
     }return arr;   
    }
}