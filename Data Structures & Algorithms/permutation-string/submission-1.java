class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;


        int[] alpha = new int[26]; // To be O(1) space

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            alpha[c - 'a']++;
        }

        // Iterate over the list and make it not go over
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (check(i, s1.length(), s2, alpha)) return true;
        }

        


        return false;
    }

    // index to know where to start
    // sizeOfS1 to offset or upperbound
    // s2 to compare and grab
    // alpha to compare
    private boolean check(int index, int sizeOfS1, String s2, int[] alpha) {
        int[] local = new int[26];

        // We want to go over it
        for (int i = index; i < index + sizeOfS1; i++) {
            char c = s2.charAt(i);
            local[c - 'a']++;
        }

        return Arrays.equals(local, alpha);
    }
}
