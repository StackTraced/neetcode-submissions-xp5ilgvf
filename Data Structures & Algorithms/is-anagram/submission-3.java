class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char sc : s.toCharArray()) {
            map.put(sc, map.getOrDefault(sc, 0) + 1);
        }

        for (char tc : t.toCharArray()) {
            if (map.getOrDefault(tc, 0) > 0) {
                map.put(tc, map.get(tc) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
