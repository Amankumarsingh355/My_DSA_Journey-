class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        double sum = 0;
        int rem = (int)(arr.length * 0.05);
        for (int i = rem; i < arr.length - rem; i++) {
            sum += arr[i];
        }
        return sum / (arr.length - (rem * 2));
    }
}