class Solution {
    boolean check(String s1,char c1,char c2, char c3, char c4)
    {
        StringBuilder s2 = new StringBuilder();
        s2.append(c1);
        s2.append(c2);
        s2.append(c3);
        s2.append(c4);

        for(int i = 0; i < s1.length(); i++)
        {
            if(s1.charAt(i) != s2.charAt(i)) return false;
        }
        
        return true;
    }
    public boolean canBeEqual(String s1, String s2) {
        char[] s = new char[4];
        
        for(int i = 0; i < s2.length(); i++)
        {
            s[i] = s2.charAt(i);
        }

        if(check(s1,s[0],s[1],s[2],s[3])) return true;
        if(check(s1,s[0],s[3],s[2],s[1])) return true;
        if(check(s1,s[2],s[1],s[0],s[3])) return true;
        if(check(s1,s[2],s[3],s[0],s[1])) return true;
        return false;
    }
}