class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // With n = 1, we have 1 opening and 1 closing, hence 2
        StringBuilder sb = new StringBuilder();
        
        compute(sb, result, 0, 0, n * 2, 0);

        return result;
    }


    private void compute(StringBuilder sb, List<String> result, int leftPar, int rightPar, int maxAmount, int index) {
        // If we are over we go back
        //if (leftPar > maxAmount || rightPar > maxAmount) return;


        // Changed to OR to test behavior
        if (sb.length() == maxAmount) {
            if (validParentheses(sb.toString())) result.add(sb.toString());
            return;
        }

        // Simple back tracking
        for (int i = index; i < maxAmount; i++) {
            // How do we determine to add a closing or open?
            // Lets just spam open
            sb.append("(");
            compute(sb, result, leftPar + 1, rightPar, maxAmount, i + 1);
            
            sb.setLength(sb.length() - 1);
            sb.append(")");
            compute(sb, result, leftPar, rightPar + 1, maxAmount, i + 1);
            sb.setLength(sb.length() - 1);
        }

    }

    // We are assuming it's of size n whenever passed here
    private boolean validParentheses(String candidate) {
        // Quick checker
        //if (candidate.charAt(0) != '(' || candidate.charAt(candidate.length() - 1) != ')') return false;


        // Put opening in here
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c: candidate.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            }

            // We can assume its a closing
            else if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                stack.pop();
            }
            // It's just not one of the option or not valid
            else return false;
        }

        return stack.isEmpty();
    }
}
