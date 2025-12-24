class Solution {
    public int thirdMax(int[] nums) {
      long thirdMax = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, firstMax = Long.MIN_VALUE;
        for (int x : nums) {
            long num = x;
            if (num == firstMax || num == secondMax || num == thirdMax)
                continue;
            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax) {
                thirdMax = num;
            }
        }
        if (thirdMax == Long.MIN_VALUE)
            return (int) firstMax;
        return (int) thirdMax;
    }
}