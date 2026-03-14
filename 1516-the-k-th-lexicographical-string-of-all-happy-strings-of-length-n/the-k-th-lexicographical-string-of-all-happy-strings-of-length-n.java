class Solution {
          ArrayList<String> result=new ArrayList<>();
    public String getHappyString(int n, int k) {
        if((3*Math.pow(2,n-1))<k){
            return "";
        }
        generate("a",n,k);
        generate("b",n,k);
        generate("c",n,k);
        return result.get(k-1);
    }
    private void generate(String cur,int n,int k){
        if(result.size()==k) return ;
        if(cur.length()==n){
            result.add(cur);
            return;
        }
        int l=cur.length();
        if(cur.charAt(l-1)=='a'){
            generate(cur+"b",n,k);
            generate(cur+"c",n,k);
        }
        else if(cur.charAt(l-1)=='b'){
            generate(cur+"a",n,k);
            generate(cur+"c",n,k);
        }
        else{
            generate(cur+"a",n,k);
            generate(cur+"b",n,k);
        }
    }
}