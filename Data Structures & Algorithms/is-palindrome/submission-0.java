class Solution {
    public boolean isPalindrome(String s) {
        int lp = 0;
        int rp = s.length() - 1;

        while (lp <= rp) {
            char leftSide = s.charAt(lp);
            char rightSide = s.charAt(rp);

            // Check if both pointers are at alphanumeric characters
            if (!Character.isLetterOrDigit(leftSide)) {
                lp++;
                continue;
            }

            if (!Character.isLetterOrDigit(rightSide)) {
                rp--;
                continue;
            }

            if (Character.toLowerCase(leftSide) != Character.toLowerCase(rightSide)) {
                return false;
            }

            lp++;
            rp--;
        }

        return true;
    }
}
