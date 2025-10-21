public class Solution {
    static class UnionFind {
        private final Map<String, String> parent = new HashMap<>();
        private final Map<String, Double> weight = new HashMap<>();
        public void add(String x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                weight.put(x, 1.0);
            }
        }
        public String find(String x) {
            String p = parent.get(x);
            if (!p.equals(x)) {
                String root = find(p);
                weight.put(x, weight.get(x) * weight.get(p));
                parent.put(x, root);
            }
            return parent.get(x);
        }
        public void union(String x, String y, double val) {
            add(x);
            add(y);
            String rx = find(x);
            String ry = find(y);
            if (rx.equals(ry)) return;
            double wx = weight.get(x);
            double wy = weight.get(y);
            double ratio = (val * wy) / wx;
            parent.put(rx, ry);
            weight.put(rx, ratio);
        }
        public boolean connected(String x, String y) {
            return parent.containsKey(x) && parent.containsKey(y) && find(x).equals(find(y));
        }
        public double ratio(String x, String y) {
            return weight.get(x) / weight.get(y);
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind uf = new UnionFind();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String a = eq.get(0), b = eq.get(1);
            uf.union(a, b, values[i]);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0), b = queries.get(i).get(1);
            if (!uf.parent.containsKey(a) || !uf.parent.containsKey(b) || !uf.connected(a, b)) {
                ans[i] = -1.0;
            } else {
                ans[i] = uf.ratio(a, b);
            }
        }
        return ans;
    }
}