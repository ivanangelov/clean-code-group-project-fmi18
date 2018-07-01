import java.util.Stack;

public class BalancedBrackets {
    private static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char curr = expression.charAt(i);
            if (stack.empty()) {
                stack.push(curr);
            } else {
                char topOfStack = stack.peek();
                if (curr == '}' && topOfStack == '{') stack.pop();
                else if (curr == ']' && topOfStack == '[') stack.pop();
                else if (curr == ')' && topOfStack == '(') stack.pop();
                else stack.push(curr);
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));
    }
}
