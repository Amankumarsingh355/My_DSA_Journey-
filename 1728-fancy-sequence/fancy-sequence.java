class Fancy {

    long mod = 1000000007;
    ArrayList<Long> val = new ArrayList<>();
    long a = 1, b = 0;

    long modPow(long x, long y){
        long res = 1;
        x %= mod;
        while(y > 0){
            if((y & 1) == 1){
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            y >>= 1;
        }
        return res;
    }

    public Fancy(){}

    public void append(int v){
        long x = (v - b + mod) % mod;
        val.add((x * modPow(a, mod - 2)) % mod);
    }

    public void addAll(int inc){
        b = (b + inc) % mod;
    }

    public void multAll(int m){
        a = (a * m) % mod;
        b = (b * m) % mod;
    }

    public int getIndex(int idx){
        if(idx >= val.size()) return -1;
        return (int)((a * val.get(idx) + b) % mod);
    }
}