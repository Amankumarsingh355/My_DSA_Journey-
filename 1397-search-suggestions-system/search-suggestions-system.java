import java.util.*;

public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        for (int prefixLen = 1; prefixLen <= searchWord.length(); prefixLen++) {
            String prefix = searchWord.substring(0, prefixLen);
            int start = lowerBound(products, prefix);
            List<String> suggestions = new ArrayList<>();
            for (int i = start; i < Math.min(start + 3, products.length); i++) {
                if (products[i].startsWith(prefix)) suggestions.add(products[i]);
                else break;
            }
            result.add(suggestions);
        }
        return result;
    }

    // Find first index i such that products[i] >= key lexicographically (lower bound)
    private int lowerBound(String[] products, String key) {
        int lo = 0, hi = products.length; // hi is exclusive
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (products[mid].compareTo(key) < 0) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // quick test
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] products1 = {"mobile","mouse","moneypot","monitor","mousepad"};
        String search1 = "mouse";
        System.out.println(s.suggestedProducts(products1, search1));
        String[] products2 = {"havana"};
        String search2 = "havana";
        System.out.println(s.suggestedProducts(products2, search2));
    }
}