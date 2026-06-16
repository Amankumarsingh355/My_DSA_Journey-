class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch == '*'){
                if(res.length() > 0){
                    res.deleteCharAt(res.length() - 1);
                }
            }else if(ch == '#'){
                res.append(res);
            }else if(ch == '%'){
                res.reverse();
            }else{
                res.append(ch);
            }
        }
        return res.toString();
    }
}