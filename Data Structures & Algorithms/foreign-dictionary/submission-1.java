class Solution {
    public String foreignDictionary(String[] words) {
        String result = "";

        List<char[]> bucket = new ArrayList<>();

        // Insert in each HashMap to prevent dupes and grab unique chars
        Set<Character> set = new HashSet<>();
        
        for(String s: words) {
            for(char c: s.toCharArray()) {
                set.add(c);
            }
        }

        // Said map is going to have a key, and character they unlock
        HashMap<Character, Set<Character>> map = new HashMap<>();

        for(char c: set) {
            map.put(c, new HashSet<>());
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

            bucket.add(localChar);
        }


        for(char[] b: bucket) {
            map.get(b[0]).add(b[1]);
        }

        // printing the map
        for(var v: map.entrySet()) {
            Set<Character> localSet = v.getValue();
            System.out.printf("%c and the size is:%d\n", v.getKey(), localSet.size());
        }

        // Working with chars, so we can make a char array
        // 0 - not seen, 1 - seen, 2 - complete
        
        int[] alpha = new int[26]; // '#' - 'a' .. 0, 1, 2....
        List<Character> list = new ArrayList<>();

        for(char s: set) {
            if (!dfs(list, alpha, s, map) ) {
                return result;
            }
        }

        // Now we have the dependency map 
        // This list it backwards
        StringBuilder sb = new StringBuilder();
        for (char c: list) {
            sb.append(c);
        }

        result = sb.reverse().toString();

        return result;
    }

    private boolean dfs(List<Character> list, int[] alpha, char currentChar, 
    HashMap<Character, Set<Character>> map) {

        int status = alpha[currentChar - 'a'];

        if (status == 2) return true;

        if (status == 1) return false;

        alpha[currentChar - 'a'] = 1;

        Set<Character> pre = map.get(currentChar);

        for(char c: pre) {
            if (!dfs(list, alpha, c, map) ) {
                return false;
            }
        }

        alpha[currentChar - 'a'] = 2;
        list.add(currentChar);

        return true;
    }

    
    private char[] differenceFinder(String x, String y) {
        char[] a = x.toCharArray();
        char[] b = y.toCharArray();

        int smallestBound = Math.min(x.length(), y.length());

        int pointer = 0;

        while (pointer < smallestBound) {
            if (a[pointer] != b[pointer]) {
                return new char[]{a[pointer], b[pointer]};
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
