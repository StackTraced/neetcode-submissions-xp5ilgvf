class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.valueOf(tokens[0]);
        }

        Stack<Integer> stack = new Stack<>();
        

        // Guaranteed size of one
        for (int i = 0; i < tokens.length; i++) {
            // If the symbols
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int latestValue = stack.pop();
                System.out.println("Latest Value: " + latestValue);
                int value = stack.pop();
                System.out.println("Value: " + value);

                switch(tokens[i]) {
                    case "+": stack.add(latestValue + value); break;
                    case "-": stack.add(value - latestValue); break;
                    case "*": stack.add(latestValue * value); break;
                    case "/": stack.add(value / latestValue); break;
                }

                System.out.println("What we have: " + stack.peek());
            }

            else {
                System.out.println("Adding: " + tokens[i]);
                stack.add(Integer.valueOf(tokens[i]));
            }
        }




        return stack.pop();

    }
}
