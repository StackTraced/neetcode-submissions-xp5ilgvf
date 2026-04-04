class Solution {
    public boolean isAnagram(String s, String t) {
        // Check the size
        if (s.length() != t.length()) return false;

        int[] storage = new int[26];

        for (int i = 0; i < s.length(); i++) {
            storage[s.charAt(i) - 'a']++;
            storage[t.charAt(i) - 'a']--;
        }

        // Check if it's zero out
        for(int j: storage) {
            if (j != 0) return false;
        }
        
        
        return true;
    }
}
