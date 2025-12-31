class Solution {
    public String restoreString(String s, int[] indices) {
        int length=s.length();
        StringBuilder sb=new StringBuilder("");
         char c[]=new char[length];
        for(int i=0;i<length;i++){
            c[indices[i]]=s.charAt(i);
        }
        sb.append(c);
        return sb.toString();
    }
}