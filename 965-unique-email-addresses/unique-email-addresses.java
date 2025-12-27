class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hashSet = new HashSet();
        for(String email:emails){
            hashSet.add(getValidEmail(email));
        }
        return hashSet.size();
    }
    public String getValidEmail(String email){
        StringBuilder sb = new StringBuilder();
        int index = email.indexOf('@');
        for(int i=0;i<index;i++){
            char ch = email.charAt(i);
            if(ch=='.'){
                continue;
            }
            if(ch=='+'){
                break;
            }
            else{
                sb.append(ch);
            }
        }
        sb.append(email.substring(index));
        return sb.toString();
    }
}