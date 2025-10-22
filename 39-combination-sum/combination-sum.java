public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int[] candidates, int remaining, int start, List<Integer> cur, List<List<Integer>> res) {
        if (remaining == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int val = candidates[i];
            if (val > remaining) break; 
            cur.add(val);
            backtrack(candidates, remaining - val, i, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum(new int[]{2,3,6,7}, 7)); 
        System.out.println(s.combinationSum(new int[]{2,3,5}, 8));
    }
}