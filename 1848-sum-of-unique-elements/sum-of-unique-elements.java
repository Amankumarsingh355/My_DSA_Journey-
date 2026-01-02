class Solution {
    public int sumOfUnique(int[] nums) {
        int n = nums.length;
        int freq[] = new int[101];
        for(int i = 0;i<n;i++) freq[nums[i]]++;
        int sum = 0;
        for(int i = 0;i<101;i++){
            if(freq[i] == 1) sum += i;
        }
        return sum;
    }
}