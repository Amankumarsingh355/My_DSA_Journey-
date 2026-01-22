class Solution {
    public int minimumPairRemoval(int[] nums) {

        List<Integer> l = new ArrayList<>();
        for (int i : nums) {
            l.add(i);
        }

        int totalCount = 0;


        while (!checkSorted(l)) {
            int min = Integer.MAX_VALUE;
            int ind = 0;
            for (int i = 0; i < l.size() - 1; i++) {
                if (min > (l.get(i) + l.get(i + 1))) {
                    min = (l.get(i) + l.get(i + 1));
                    ind = i;
                }
            }

            l.set(ind, min);
            l.remove(ind + 1);
            totalCount++;
        }

        return totalCount;


    }
    private boolean checkSorted(final List<Integer> list) {
        int len = list.size();

        for (int i = 0; i < len - 1; i++) {
            if (list.get(i) > list.get(i + 1)) return false;
        }
        return true;
    }
}