class Solution {
    public String makeLargestSpecial(String s) {
        int n=s.length();
        for(int i=0;i<n;i++){
            //starting point
            if(s.charAt(i)=='0') continue;
            // SBS cannot start with 0
            int x=0; // count
            int s1=i,e1=-1,s2=-1,e2=-1;
            for(int j=i;j<n;j++){
                if(s.charAt(j)=='1')x++;
                else x--;
                if(x==0){
                    if(e1==-1){
                        e1=j;
                        if(j+1>=n || s.charAt(j+1)=='0') break;
                        s2=j+1;
                    }else if(e2==-1){
                        e2=j;
                        break;
                    }
                }
            }
            
            if(s1!=-1 && e1!=-1 && s2!=-1 && e2!=-1){
               
                String temp=s.substring(0,s1)+s.substring(s2,e2+1)+s.substring(s1,e1+1)+s.substring(e2+1);
                if(temp.compareTo(s)>0) {
                    return makeLargestSpecial(temp);
                }
            }
            
            
            
        }
        return s;
        
    }
}