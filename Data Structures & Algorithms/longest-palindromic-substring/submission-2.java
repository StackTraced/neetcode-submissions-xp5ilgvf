class Solution {
    public String longestPalindrome(String s) {
        
        String resultSingle = "";
        String resultDouble = "";
        
        String output = "";

        for(int i = 0; i < s.length(); i++) {
            resultSingle = palindromeFinder(s, i, i);
            resultDouble = palindromeFinder(s, i, i + 1);

            if (resultSingle.length() > output.length()) {
                output = resultSingle;
            }
            if (resultDouble.length() > output.length()) {
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
                lp--;
                rp++;
            }

            // If it doesn't exit early
            else {
                break;
            }
        }

        // Then we substring it?
        return s.substring(lp + 1, rp);
    }
}
