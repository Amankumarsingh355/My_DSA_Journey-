class Solution {
    public int longestBalanced(String s) {
        int maxLength = 0;
        for(int i =0; i<s.length(); i++)
        {   int freq[] = new int[26];
            for(int j = i; j<s.length(); j++)
            {
                freq[s.charAt(j) - 'a'] += 1;
                if(isBalanced(freq))
                {
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
    return maxLength;
    }
    public boolean isBalanced(int freq[])
    {
        int prev = 0;
        for(int j : freq)
        {
            if(j > 0)
            {
                if(prev == 0)
                {
                    prev = j;
                }
                else if(prev != j)
                {
                    return false;
                }
            }
        }
    return true;
    }
}