class Solution {
    public boolean isPalindrome(String s) {
        // Convert the string into chars
        char[] charArray = s.toCharArray();
        int lp = 0;
        int rp = charArray.length - 1;

        while(lp <= rp) {
            // Check if the pointers are even characters
            if (!Character.isLetter(charArray[lp]) && !Character.isDigit(charArray[lp])) {
                lp++;
                continue;
            }

            if (!Character.isLetter(charArray[rp]) && !Character.isDigit(charArray[rp])) {
                rp--;
                continue;
            }

            // Check if they are equal
            if (Character.toLowerCase(charArray[lp]) != Character.toLowerCase(charArray[rp])) {
                return false;
            }

            lp++;
            rp--;

        }

        return true;
    }
}
