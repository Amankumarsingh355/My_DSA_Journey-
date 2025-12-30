class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] integerArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Comparator<Integer> comparator = new BitCountComparator();
        Arrays.sort(integerArr, comparator);
        int[] sortedArr = Arrays.stream(integerArr).mapToInt(Integer::intValue).toArray();
        return sortedArr;
    }
}
class BitCountComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        int bitCountA = Integer.bitCount(a);
        int bitCountB = Integer.bitCount(b);
        if (bitCountA == bitCountB) {
            return a - b;
        } else {
            return bitCountA - bitCountB;
        }
    }
}