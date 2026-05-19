class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        StringBuilder sb = new StringBuilder();

        HashMap<Character, List<Character>> numPad = new HashMap<>();
        numPad.put('2', List.of('a', 'b', 'c'));
        numPad.put('3', List.of('d', 'e', 'f'));
        numPad.put('4', List.of('g', 'h', 'i'));
        numPad.put('5', List.of('j', 'k', 'l'));
        numPad.put('6', List.of('m', 'n', 'o'));
        numPad.put('7', List.of('p', 'q', 'r', 's'));
        numPad.put('8', List.of('t', 'u', 'v'));
        numPad.put('9', List.of('w', 'x', 'y', 'z'));

        combo(result, numPad, digits, 0, sb);



        return result;
    }

    private void combo(
        List<String> result, 
        HashMap<Character, List<Character>> numPad, 
        String digits, 
        int digitPosition, 
        StringBuilder sb
    ) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        // We are given the digit position, load up its array
        List<Character> loaded = numPad.get(digits.charAt(digitPosition));
        // When given a char

        for(int i = 0; i < loaded.size(); i++) {
            sb.append(loaded.get(i));
            
            // Backtrack - Simple for loop
            combo(result, numPad, digits, digitPosition + 1, sb);

            sb.setLength(sb.length() - 1);
        }
    }
}
