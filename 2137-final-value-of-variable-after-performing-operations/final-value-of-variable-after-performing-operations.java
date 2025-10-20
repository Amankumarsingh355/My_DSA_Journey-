class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for (String op : operations) {
            X += op.charAt(1) == '+' ? 1 : -1;
        }
        return X;
    }
}