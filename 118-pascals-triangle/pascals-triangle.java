class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows <= 0) return triangle;
        triangle.add(Collections.singletonList(1));
        for (int r = 2; r <= numRows; r++) {
            List<Integer> prev = triangle.get(r - 2);
            List<Integer> row = new ArrayList<>(r);
            row.add(1);
            for (int j = 1; j < r - 1; j++) {
                row.add(prev.get(j - 1) + prev.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.generate(5));
        System.out.println(sol.generate(1));
    }
}