class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<Integer> seen = new HashSet<>();

        for (String num : nums) {
            seen.add(Integer.parseInt(num, 2));
        }

        for (int i = 0; i < (1 << n); i++) {
            if (!seen.contains(i)) {
                String bin = Integer.toBinaryString(i);
                while (bin.length() < n) {
                    bin = "0" + bin;
                }
                return bin;
            }
        }
        return "";
    }
}