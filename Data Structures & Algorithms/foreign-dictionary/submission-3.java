class Solution {
    public String foreignDictionary(String[] words) {
 
        // Said map is going to have a key, and character they unlock
        Map<Character, Set<Character>> map = new HashMap<>();
        
        for(String s: words) {
            for(char c: s.toCharArray()) {
                map.putIfAbsent(c, new HashSet<>());
            }
        }

        // Setup the pre-requisites
        for(int i = 0; i < words.length - 1; i++) {
            char[] localChar = differenceFinder(words[i], words[i + 1]);

            if (localChar == null) {
                return "";
            }
            else if(localChar.length == 0) {
                continue;
            }

            map.get(localChar[0]).add(localChar[1]);
        }

        // Working with chars, so we can make a char array
        // 0 - not seen, 1 - seen, 2 - complete
        
        int[] alpha = new int[26]; // '#' - 'a' .. 0, 1, 2....
        List<Character> list = new ArrayList<>();

        for(char s: map.keySet()) {
            if (hasCycle(s, list, alpha, map) ) {
                return "";
            }
        }

        // Now we have the dependency map 
        // This list it backwards
        StringBuilder sb = new StringBuilder();

        for (char c: list) {
            sb.append(c);
        }

        return sb.reverse().toString();
    }

    private boolean hasCycle(char currentChar, List<Character> list, int[] alpha, 
    Map<Character, Set<Character>> map) {

        int status = alpha[currentChar - 'a'];

        if (status == 2) return false;

        if (status == 1) return true;

        alpha[currentChar - 'a'] = 1;

        Set<Character> next = map.get(currentChar);

        for(char c: next) {
            if (hasCycle(c, list, alpha, map) ) {
                return true;
            }
        }

        alpha[currentChar - 'a'] = 2;
        list.add(currentChar);

        return false;
    }

    
    private char[] differenceFinder(String x, String y) {
        int smallestBound = Math.min(x.length(), y.length());

        int pointer = 0;

        while (pointer < smallestBound) {
            if (x.charAt(pointer) != y.charAt(pointer)) {
                return new char[]{x.charAt(pointer), y.charAt(pointer)};
            }

            pointer++;
        }

        if (x.length() > y.length()) {
            return null;
        } else {
            return new char[0];
        }
    }
}
