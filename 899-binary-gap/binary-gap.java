class Solution {
    public int binaryGap(int n) {
        int longest = 0;
        String s = Integer.toBinaryString(n);
        int lastOne = -1;
        for(int i = 0; i<s.length();i++){
        if(s.charAt(i) == '1'){
            if(lastOne != -1){
                longest = Math.max(i - lastOne,longest);
            }
            lastOne = i;
        }
        }
        return longest;
    }
}