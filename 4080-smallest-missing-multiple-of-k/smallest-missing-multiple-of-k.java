class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> present = new HashSet<>();
        for (int num : nums) {
            present.add(num);
        }
        int multiple = k;
        while (present.contains(multiple)) {
            multiple += k;
        }
        return multiple;
    }
}