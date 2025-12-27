class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> targetIndex = getIndexOfTarget(s, c);
        int[] ans = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            int result = Integer.MAX_VALUE;
            for(int j = 0; j < targetIndex.size(); j++){
                result = Math.min(result, Math.abs(i - targetIndex.get(j)));
            }
            ans[i] = result;
        }
        return ans;
    }
    List<Integer> getIndexOfTarget(String s, char c){
        List<Integer> indexs = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                indexs.add(i);
            }
        }
        return indexs;
    }
}