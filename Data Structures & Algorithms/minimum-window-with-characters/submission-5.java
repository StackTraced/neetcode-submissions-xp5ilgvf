class Solution {
    public String minWindow(String s, String t) {
        // We would need a window of size t, minimum
        if (s.length() < t.length()) return ""; // s being too small
        if (s.equals(t)) return t; // Same word, instantly found   

        String word = s + t;

        HashMap<Character, Integer> counter = new HashMap<>();

        // build the counter
        for (char c: t.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        int buildingBlocks = counter.size();
        int lp = 0;

        for (int rp = 0; rp < s.length(); rp++) {
            char c = s.charAt(rp);

            if (counter.containsKey(c)) {

                counter.put(c, counter.get(c) - 1);

                if (counter.get(c) == 0) {
                    buildingBlocks--;
                }
            }

            while (buildingBlocks == 0) {
                String potential = s.substring(lp, rp + 1);
                
                if (potential.length() < word.length()) {
                    word = potential;
                }

                char tmp = s.charAt(lp);
                
                if (counter.containsKey(tmp)) {
                    counter.put(tmp, counter.get(tmp) + 1);
                    if (counter.get(tmp) > 0) {
                        buildingBlocks++;
                    }
                }
                
                lp++;
            }

        }


        return word.equals(s + t) ? "" : word;
    }
}
