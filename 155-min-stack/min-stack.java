public class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> mins;
    public MinStack() {
        stack = new ArrayDeque<>();
        mins = new ArrayDeque<>();
    }
    public void push(int val) {
        stack.push(val);
        if (mins.isEmpty() || val <= mins.peek()) {
            mins.push(val);
        } else {
            mins.push(mins.peek());
        }
    }
    public void pop() {
        stack.pop();
        mins.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return mins.peek();
    }
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin()); 
        ms.pop();
        System.out.println(ms.top());  
        System.out.println(ms.getMin()); 
    }
}