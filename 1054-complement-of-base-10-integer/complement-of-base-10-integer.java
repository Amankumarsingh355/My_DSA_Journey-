class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int count = 0, num = n;
        while(n > 0){
            n = n >> 1;
            count++;
        }

        int mask = (int) Math.pow(2,count) - 1;

        return num ^ mask; 

    }
}