class Solution {
    public boolean isValid(String s) {
        // Filter to prevent unneeded computations
        if (s.length() %2 != 0) {
            return false;
        }


        // Create a dictionary to store the combinations
        Map<Character, Character> dict = new HashMap<>();
        dict.put(')', '(');
        dict.put(']', '[');
        dict.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if(!stack.empty() && dict.containsKey(c) && dict.get(c) == stack.peek()){
                stack.pop();
            }
            else{
                return false;
            }
        }

        return stack.empty() ? true : false;
    }
}