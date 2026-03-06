class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        boolean bool1 = false;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == '0'){
                bool1 = true;
            }
            if(bool1 == true && s.charAt(i) == '1'){
                return false;
            }
        }
        return true;
    }
}