import java.util.Stack;

/**
 *A simple class for Bralanced Brackets task on hackerrank.
 */
public class BalancedBrackets {
    /**
     *A static method with the solution.Checks if the brackets in an expression are balanced.
     *@param expression a string representing the expression with the brackets
     */
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
