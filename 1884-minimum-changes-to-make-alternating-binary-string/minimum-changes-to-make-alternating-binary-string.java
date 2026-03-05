class Solution {
    public int minOperations(String s) {
        int n   = s.length();
        int start_with_1 = 0;

        for( int i = 0; i < n; i++ ) {
            char ch = s.charAt(i);
            if( i % 2  != 0 ) {
                if( ch == '0' ) {
                    start_with_1 += 1;
                }
            }
            else{
                if( ch == '1' ) {
                    start_with_1 += 1;
                }
            }
        }
        

        return Math.min( start_with_1, n - start_with_1 );

    }
}