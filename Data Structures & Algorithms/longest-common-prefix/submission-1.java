class Solution {
    public String longestCommonPrefix(String[] strs) {
        int lp = 0;
        int rp = 0;

        String longest = "";

        // smallest word
        int minLength = Integer.MAX_VALUE;
        for (String s: strs) {
            minLength = Math.min(minLength, s.length());
        }

        // anchor is always 0
        for (int i = 0; i < minLength; i++) {
            // iterate over bait
            String prefix = strs[0].substring(0, i + 1);

            // Check if every word startsWith it
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix)) return longest;
            }

            // IF we get here it made it so
            longest = prefix;
        }

        return longest;
    }
}