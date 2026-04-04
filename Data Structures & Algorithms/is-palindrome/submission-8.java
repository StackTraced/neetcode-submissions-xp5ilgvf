class Solution {
    public boolean isPalindrome(String s) {

        // Make the entire thing lowercase
        s = s.toLowerCase();

        int lp = 0;
        int rp = s.length() - 1;

        while (lp <= rp) {
            // Find the contradiction
            // but we want an apples-to-apples comparison
            
            // Do I need to add an lp checker here??
            while(lp < s.length() && !Character.isLetterOrDigit(s.charAt(lp))){
                lp++;
            }

            while(rp >= 0 && !Character.isLetterOrDigit(s.charAt(rp))) {
                rp--;
            }

            // Check if they crossed each other
            if (lp > rp) {
                return true;
            }

            // Then check after we have two letters, if they are equal
            if (s.charAt(lp) != s.charAt(rp)) {
                return false;
            }

            // Increment and move
            lp++;
            rp--;
        }

        // we assume true, until proven otherwise
        return true;
    }
}
