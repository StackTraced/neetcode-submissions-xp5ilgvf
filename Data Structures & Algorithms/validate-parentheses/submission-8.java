class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> checker = new Stack<>();
        char c;

        HashMap<Character, Character> mapper = new HashMap<>();
        mapper.put(')', '(');
        mapper.put(']', '[');
        mapper.put('}', '{');

        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            
            // Add to the stack if these following
            if (c == '(' || c == '{' || c == '[') {
                checker.push(c);
            }

            else if(!checker.isEmpty() && (mapper.get(c) == checker.peek())) {
                checker.pop();
            }

            else {
                return false;
            }

        }




        return checker.isEmpty();
    }
}
