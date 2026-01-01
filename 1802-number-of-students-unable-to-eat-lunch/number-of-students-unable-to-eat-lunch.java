class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] stCount = new int[2];
        for (int st : students) {
            stCount[st]++;
        }
        for (int sn : sandwiches) {
            if (stCount[sn] == 0) {
                return stCount[0] + stCount[1];
            }
            stCount[sn]--;
        }
        return 0;
    }
}