class Solution {
    // Time: O(n) since both lp and rp pointers each only move forward once
    // Space: O(k) where k is the unique number of character strings
    public int lengthOfLongestSubstring(String s) {
        int lp = 0;
        int rp = 0;
        int maxSize = 0;
        Set<Character> memory = new HashSet<>();
        
        while (rp < s.length()) {
            char currentChar = s.charAt(rp);

            // Check if the character is already in the memory
            if (memory.contains(currentChar)) {
                memory.remove(s.charAt(lp++));
            } else {
                memory.add(currentChar);
                rp++;
                maxSize = Math.max(maxSize, memory.size());
            }
        }

        return maxSize;
    }
}
