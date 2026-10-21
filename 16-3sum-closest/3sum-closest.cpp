class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int closest = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.size(); i++){
            int j = i + 1;
            int k = nums.size() - 1;
            int sum = 0;
            while(j < k){
                sum = nums[i] + nums[j] + nums[k];
                if(abs(target - sum) < abs(closest - target)){
                    closest = sum;
                }
                if(sum < target){
                    j++;
                }
                else if(sum > target){
                    k--;
                }
                else{
                    return target;
                }
            }
        }
        return closest;
    }
};