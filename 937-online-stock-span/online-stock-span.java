public class StockSpanner {
    private static class Pair {
        int price;
        int span;
        Pair(int p, int s) { price = p; span = s; }
    }
    private final Deque<Pair> stack;
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.pop().span;
        }
        stack.push(new Pair(price, span));
        return span;
    }
    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        System.out.println(s.next(100)); 
        System.out.println(s.next(80)); 
        System.out.println(s.next(60)); 
        System.out.println(s.next(70)); 
        System.out.println(s.next(60));  
        System.out.println(s.next(75)); 
        System.out.println(s.next(85)); 
    }
}