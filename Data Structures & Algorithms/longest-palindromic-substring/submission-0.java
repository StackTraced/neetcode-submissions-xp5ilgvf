class Solution {
    public String longestPalindrome(String s) {
        // If it's size one, return it
        if (s.length() == 1) {
            return s;
        }
        
        String resultSingle = "";
        String resultDouble = "";
        
        String output = "";

        for(int i = 0; i < s.length(); i++) {
            resultSingle = palindromeFinder(s, i, i);
            resultDouble = palindromeFinder(s, i, i + 1);

            // Find which one is 'longer'
            if ((resultSingle.length() > resultDouble.length()) && resultSingle.length() > output.length()) {
                output = resultSingle;
            } 
            else if ((resultDouble.length() > resultSingle.length()) && resultDouble.length() > output.length()) {
                output = resultDouble;
            }
        }

        return output;
    }

    private String palindromeFinder(String s, int lp, int rp) {
        // We start from the side
        

        // We want to expand it

        // We get -1? 
        // Cause we decrement it
        String potential = "";

        while (lp >= 0 && rp < s.length()) {
            // Check if the match
            if (s.charAt(lp) == s.charAt(rp)) {
                // expand them
                // Grab it first then adjust
                potential = s.substring(lp, rp + 1);
                lp--;
                rp++;
            }

            // If it doesn't exit early
            else {
                break;
            }
        }

        // Then we substring it?
        return potential;
    }
}
