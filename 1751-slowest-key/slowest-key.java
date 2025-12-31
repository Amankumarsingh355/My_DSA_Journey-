public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxi = releaseTimes[0]; 
        char lar = keysPressed.charAt(0); 
        int n = releaseTimes.length;
        for (int i = 1; i < n; i++) {
            int diff = releaseTimes[i] - releaseTimes[i - 1];
            if (diff > maxi) {
                maxi = diff;
                lar = keysPressed.charAt(i);
            } else if (diff == maxi && keysPressed.charAt(i) > lar) {
                lar = keysPressed.charAt(i);
            }
        }
        return lar;
    }
}