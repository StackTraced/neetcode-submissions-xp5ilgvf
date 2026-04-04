class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> checker = new Stack<>();

        HashMap<Character, Character> mapper = new HashMap<>();
        mapper.put(')', '(');
        mapper.put(']', '[');
        mapper.put('}', '{');

        for(char c: s.toCharArray()) {
            
            // We have a closing char
            if (mapper.containsKey(c)) {
                if (!checker.isEmpty() && (checker.peek() == mapper.get(c))) {
                    checker.pop();
                }
                else {
                    return false;
                }
            }
            else {
                checker.push(c);
            }
            
        }


        return checker.isEmpty();
    }
}
