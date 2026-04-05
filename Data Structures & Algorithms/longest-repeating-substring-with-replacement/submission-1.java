class Solution {
    public int characterReplacement(String s, int k) {
        int lp = 0;
        int rp = 0;
        int maxFreq = 0;

        int[] alpha = new int[26];

        int maxSize = 0;

        while (rp < s.length()) {
            // Compute and grab
            char c = s.charAt(rp);
            alpha[c - 'A']++;
            maxFreq = Math.max(maxFreq, alpha[c - 'A']);

            // Check if window is valid
            int windowSize = (rp - lp) + 1; // actual window itself

            // Check if its valid
            if (windowSize - maxFreq <= k) {
                maxSize = Math.max(maxSize, windowSize);
                rp++;
            }
            else {
                alpha[s.charAt(lp) - 'A']--;
                lp++;
                rp++;
            }
        }

        return maxSize;
    }
}
