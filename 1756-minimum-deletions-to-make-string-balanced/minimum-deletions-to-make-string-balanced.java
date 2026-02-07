class Solution{
    public int minimumDeletions(String s){
        int min=s.length();
        int x=0;
        int b1=0;
        int a1=0;
        for(int j=0; j<s.length();j++){
            if(s.charAt(j)=='a'){
                a1++;
            }
        }
        for(int i=0;i<s.length();i++){
            int y=i+1;

            while(x<i){
                if(s.charAt(x)=='b'){
                    b1++;
                }
                x++;
            }
            if(s.charAt(y-1)=='a'){
                a1--;
            }
            min=Math.min(min,a1+b1);
        }
        return min;
    }
}