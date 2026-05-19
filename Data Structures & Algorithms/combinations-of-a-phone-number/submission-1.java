class Solution {

    String[] numPad = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        StringBuilder sb = new StringBuilder();

        combo(result, numPad, digits, 0, sb);



        return result;
    }

    private void combo(
        List<String> result, 
        String[] numPad, 
        String digits, 
        int digitPosition, 
        StringBuilder sb
    ) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        // We are given the digit position, load up its array
        String loaded = numPad[digits.charAt(digitPosition) - '0'];
        // When given a char

        for(int i = 0; i < loaded.length(); i++) {
            sb.append(loaded.charAt(i));
            
            // Backtrack - Simple for loop
            combo(result, numPad, digits, digitPosition + 1, sb);

            sb.setLength(sb.length() - 1);
        }
    }
}
