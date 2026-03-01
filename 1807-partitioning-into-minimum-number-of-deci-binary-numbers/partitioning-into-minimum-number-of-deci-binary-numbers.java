class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(int i=0; i<n.length(); i++) {
            int ch = n.charAt(i) - '0';
            if( ch>max){
                max = ch;
            }
        }
        return max;
    }
}