class Solution {
    public boolean hasAllCodes(String s, int k) {
        int total = 1<<k; 
        Set<String> set=new HashSet();
        for(int i=k; i<=s.length();i++){
            String s1=s.substring(i-k,i);
            if(!set.contains(s1)){
                set.add(s1);
            }        
        }
        if(set.size()==total)  return true;
        return false;
    }
}