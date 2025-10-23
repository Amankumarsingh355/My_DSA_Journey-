import java.util.ArrayDeque;
import java.util.Deque;
public class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int n = s.length();
        int result = 0;
        int sign = 1;
        int num = 0;
        boolean inNumber = false;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                inNumber = true;
                num = num * 10 + (c - '0');
            } else {
                if (inNumber) {
                    result += sign * num;
                    num = 0;
                    inNumber = false;
                }
                if (c == '+') {
                    sign = 1;
                } else if (c == '-') {
                    sign = -1;
                } else if (c == '(') {
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    sign = 1;
                } else if (c == ')') {
                    int prevSign = stack.pop();
                    int prevRes = stack.pop();
                    result = prevRes + prevSign * result;
                }
            }
        }
        if (inNumber) {
            result += sign * num;
        }
        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.calculate("1 + 1"));          
        System.out.println(s.calculate(" 2-1 + 2 "));       
        System.out.println(s.calculate("(1+(4+5+2)-3)+(6+8)")); 
        System.out.println(s.calculate("-(2+3)"));
    }
}