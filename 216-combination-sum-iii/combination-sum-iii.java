public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int start, int remainCount, int remainSum,
                           List<Integer> cur, List<List<Integer>> res) {
        if (remainCount == 0) {
            if (remainSum == 0) res.add(new ArrayList<>(cur));
            return;
        }
        for (int num = start; num <= 9; ++num) {
            if (num > remainSum) break;
            int numbersLeft = 9 - num + 1;
            if (numbersLeft < remainCount) break;
            cur.add(num);
            backtrack(num + 1, remainCount - 1, remainSum - num, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum3(3, 7));
        System.out.println(s.combinationSum3(3, 9)); 
        System.out.println(s.combinationSum3(4, 1));
    }
}