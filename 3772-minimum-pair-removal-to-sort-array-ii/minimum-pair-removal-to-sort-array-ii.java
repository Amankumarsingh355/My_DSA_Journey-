class Solution {

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        TreeSet<Pair> treeSet = new TreeSet<Pair>((a, b) -> {
            if (a.sum == b.sum) {
                return Integer.compare(a.index, b.index);
            }
            return Long.compare(a.sum, b.sum);
        }); 
        int badPairs = 0;
        int[] prevIndex = new int[n]; 
        int[] nextIndex = new int[n]; 
        long[] temp = new long[n];  
        for (int i = 0; i < n; i++) {
            temp[i] = (long) nums[i];
            prevIndex[i] = i - 1;
            nextIndex[i] = i + 1;
        }
        for (int i = 0; i < n - 1; i++) { 
            if (temp[i + 1] < temp[i]) {
                badPairs++;
            }
            treeSet.add(new Pair (temp[i] + temp[i + 1], i));
        }
        int operations = 0;
        while (badPairs > 0) { 
            Pair pair = treeSet.pollFirst();
            int first = pair.index;
            int second = nextIndex[first];
            int firstLeft = prevIndex[first];
            int secondRight = nextIndex[second];
            if (temp[first] > temp[second]) {
                badPairs--;
            }
            if (firstLeft >= 0) {
                if (temp[firstLeft] > temp[first] && 
                    temp[firstLeft] <= temp[first] + temp[second]) {
                    badPairs--;
                } else if (temp[firstLeft] <= temp[first] &&
                    temp[firstLeft] > temp[first] + temp[second]) {
                    badPairs++;
                }
            }
            if (secondRight < n) {
                if (temp[secondRight] >= temp[second] && 
                    temp[secondRight] < temp[first] + temp[second]) {
                    badPairs++;
                } else if (temp[secondRight] < temp[second] &&
                    temp[secondRight] >= temp[first] + temp[second]) {
                    badPairs--;
                }
            }
            if (firstLeft >= 0) {
                treeSet.remove(new Pair(temp[firstLeft] + temp[first], 
                    firstLeft)); 
                treeSet.add(new Pair(temp[firstLeft] + temp[first] + temp[second], 
                    firstLeft)); 
            }
            if (secondRight < n) {
                treeSet.remove(new Pair(temp[second] + temp[secondRight], 
                    second)); 
                treeSet.add(new Pair(temp[secondRight] + temp[first] + temp[second],
                    first));
                prevIndex[secondRight] = first;
            }
            nextIndex[first] = secondRight; 
            temp[first] += temp[second];
            operations++;
        }
        return operations;
    }

    static class Pair {
        long sum;
        int index;

        public Pair (long sum, int index) {
            this.sum = sum;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair p = (Pair) o;
            return p.sum == sum && p.index == index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sum, index);
        }
    }
}