class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] check = new int[50001];
        Map<Integer,int[]>  map = new HashMap<>();
        for(int i = 0;i<nums.length ; i++){
            check[nums[i]]++;
            if(map.containsKey(nums[i])){
                map.put(nums[i] , new int[]{map.get(nums[i])[0] , i + 1});
            }else{
                map.put(nums[i] , new int[]{i , i + 1});
            }
        }
        int max = 0;
        ArrayList<Integer> test= new ArrayList<>();
        for(int i = 0;i<check.length;i++){
            if(check[i]> max){
                test= new ArrayList<>();
                test.add(i);
                max = check[i];
            }else if(check[i] == max){
                test.add(i);
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i = 0;i<test.size() ;i++){
            int[] arr = map.get(test.get(i));
            ans =Math.min(ans , arr[1] - arr[0]);
        }
        return ans;
    }
}