class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Don't waste time
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        } 
        
        Set<Character> seen = new HashSet<>();
        int longestValue = 0;

        int anchor = 0;
        int runner = 0;

        while(runner < s.length()) {
            // This is unique and new
            if (!seen.contains(s.charAt(runner))) {
                // Add it to the list
                seen.add(s.charAt(runner));
                // increment the value to do math
                runner++;
                longestValue = Math.max(longestValue, runner - anchor);
            }

            // Implies we have seen it
            else {
                // Find the character
                char target = s.charAt(runner);

                while(seen.contains(target)) {
                    seen.remove(s.charAt(anchor));
                    anchor++;
                }

            }

            // Stuck in an infite loop....
        }

        return longestValue;
    }
}
