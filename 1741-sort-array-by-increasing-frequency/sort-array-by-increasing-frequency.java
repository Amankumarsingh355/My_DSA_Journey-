class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer>freq=new HashMap<>();
        for(int n:nums){
            if(freq.containsKey(n)){
            freq.put(n,freq.get(n)+1);}
            else{
                freq.put(n,1);
            }
        }
        Integer temp[]=new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp, (a, b) -> {
        int fa = freq.get(a);
        int fb = freq.get(b);
        if (fa != fb) {
            return fa - fb;   
        } else {
            return b-a;     }
        });
        for (int i = 0;i < nums.length;i++) {
             nums[i]=temp[i];
        }
        return nums;
    }
}