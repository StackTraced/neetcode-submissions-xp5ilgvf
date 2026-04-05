class Solution {
    public String minWindow(String s, String t) {
        // We would need a window of size t, minimum
        if (s.length() < t.length()) return ""; // s being too small
        if (s.equals(t)) return t; // Same word, instantly found   
        //if (s.length() == t.length()) return "";

        String word = s + t;

        HashMap<Character, Integer> counter = new HashMap<>();

        // build the counter
        for (char c: t.toCharArray()) {
            System.out.println(c);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        int lp = 0;
        int rp = 0;

        while (rp < s.length()) {
            
            // Check to see if current rp is a target, if not a target move on
            char c = s.charAt(rp);

            // Check if a character we want
            if (counter.containsKey(c)) {
                counter.put(c, counter.get(c) - 1);
            }

            if (lessThanZeroCounter(counter)) {
                // First prune the lp
                lp = pruneLeftPointer(counter, lp, s);
                String potential = s.substring(lp, rp + 1);
                
                if (potential.length() < word.length()) {
                    word = potential;
                }
            }
            
            rp++;
        }


        return word.equals(s + t) ? "" : word;
    }

    // Better way of doing this, but working on a solution first
    // Point of this method, to help determine if our window is valid
    private boolean lessThanZeroCounter(HashMap<Character, Integer> counter) {

        for (char k: counter.keySet()) {
            if (counter.get(k) > 0) return false;
        }

        return true;
    }

    // Point of this is to move the left pointer until it hits a word
    // we are guaranteed to have a valid word
    private int pruneLeftPointer(HashMap<Character, Integer> counter, int lp, String word) {
        
        while(true) {
            char c = word.charAt(lp);

            // Removes non- target words
            if (!counter.containsKey(c)) {
                lp++;
            }

            // This removes if it is a target word, but we have excess
            // We can assume it does in fact contain the key?
            else if (counter.get(c) < 0) {
                // Increment it's value
                counter.put(c, counter.get(c) + 1);
                lp++;
            }
            // Exit the loop
            else {
                break;
            }
        }

        return lp;
    }
}
