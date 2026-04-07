class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;


        int[] s1Count = new int[26]; // To be O(1) space

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            s1Count[c - 'a']++;
        }

        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            s2Count[c - 'a']++;
        }

        if (Arrays.equals(s2Count, s1Count)) return true;

        // Iterate over the list and make it not go over
        // Guarantee to be one above remove last input
        for (int i = s1.length(); i < s2.length(); i++) {
            
            s2Count[s2.charAt(i) - 'a']++;

            s2Count[s2.charAt(i - s1.length()) - 'a']--;

            if (Arrays.equals(s1Count, s2Count)) return true;
        }

        return false;
    }
}
