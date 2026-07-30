public class Solution {
    /**
     * Evaluate arithmetic expression with +, -, *, / operators.
     * Respects operator precedence without using eval.
     */
    public static int calculate(String s) {
        // Initialize stack and tracking variables
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int currentNumber = 0;
        char lastOperator = '+';
        
        // Parse expression character by character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Build multi-digit numbers
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            }
            
            // Process operator or end of string
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || i == s.length() - 1) {
                // Apply last operator with current number
                if (lastOperator == '+') {
                    stack.push(currentNumber);
                } else if (lastOperator == '-') {
                    stack.push(-currentNumber);
                } else if (lastOperator == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (lastOperator == '/') {
                    // Truncate toward zero
                    stack.push(stack.pop() / currentNumber);
                }
                
                // Update operator and reset number
                if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    lastOperator = ch;
                }
                currentNumber = 0;
            }
        }
        
        // Sum all values in stack
        int result = 0;
        for (int num : stack) {
            result += num;
        }
        return result;
    }
}
