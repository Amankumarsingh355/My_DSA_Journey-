class NumArray {
    int[] prefSum;
    public NumArray(int[] nums) {
        prefSum = new int [nums.length + 1];
        prefSum[0] = 0;
        for(int i = 0; i < nums.length; i++){
            prefSum[i + 1] = prefSum[i] + nums[i];
        }
    }
    public int sumRange(int left, int right) {
        return prefSum[right + 1] - prefSum[left];
    }
}