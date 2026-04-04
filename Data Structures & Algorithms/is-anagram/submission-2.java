class Solution {
    public boolean isAnagram(String s, String t) {
        // Check to see if they are even the same size
        if (s.length() != t.length()) {
            return false;
        }
        
        // Works with anything in the future
        HashMap<Character, Integer> map = new HashMap();

        // Add all of the values into a mapper
        for (char sc: s.toCharArray()) {
            map.merge(sc, 1, Integer::sum);
        }

        for (char tc: t.toCharArray()) {
            if (map.getOrDefault(tc, 0) > 0) {
                map.merge(tc, -1, Integer::sum);
            }
            else {
                return false;
            }
        }


        return true;
    }
}
