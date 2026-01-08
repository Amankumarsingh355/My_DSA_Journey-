class Solution {
       public List<Integer> targetIndices(int[] nums, int target) {
         int belowTCount=0, targetCount=0;
         List<Integer> ans = new ArrayList<>();    
        for(int n : nums){
            if(n<target)
                belowTCount++;
            else if(n==target)
                targetCount++;
        }
            for(int t=0;t<targetCount;t++)
                ans.add(belowTCount++);
        return ans;
    }
}