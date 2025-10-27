public class Solution {
    public int[] twoSum(int[] arr, int tgt) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int idx = 0; idx < arr.length; idx++) {
            int req = tgt - arr[idx];
            if (map.containsKey(req)) {
                return new int[] { map.get(req), idx };
            }
            map.put(arr[idx], idx);
        }
        throw new IllegalArgumentException("No two sum solution found.");
    }
}