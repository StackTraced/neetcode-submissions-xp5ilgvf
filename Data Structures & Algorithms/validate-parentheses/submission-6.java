class Solution {
    public boolean isValid(String s) {
        // If the length is odd, can't be valid
        if (s.length() %2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();


        // Opening go inside the stack
        for (int i = 0; i < s.length(); i++) {
            // Put opening pieces into the stack
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }

            // If its a closing one, which we can assume. Guarantee to be one of them
            // The stack can't be empty
            else if (!stack.empty()) {
                if (
                    s.charAt(i) == ']' && stack.peek() == '[' ||
                    s.charAt(i) == '}' && stack.peek() == '{' ||
                    s.charAt(i) == ')' && stack.peek() == '('
                )
                    stack.pop();

                else {
                    return false;
                }
            }

            else {
                return false;
            }
        }


        // If it's empty, no extra pieces
        return stack.empty();
    }
}
