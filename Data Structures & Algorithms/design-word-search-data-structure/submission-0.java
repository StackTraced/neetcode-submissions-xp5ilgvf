class WordDictionary {

    private TrieNode root;

    // Making the HashMap version on Neetcode
    // Array version on Leetcode
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;

        for (char c: word.toCharArray()) {
            current = current.children.computeIfAbsent(c, key -> new TrieNode());
        }

        current.isWord = true;
    }


    // Regular search, but if we find a ".", perform dfs
    public boolean search(String word) {
        TrieNode current = root;

        return dfsSearch(0, word, current);
    }

    private boolean dfsSearch(int index, String word, TrieNode current) {
        // Base Case - We found the word, we just need one true to be valid
        if (index == word.length()) {
            return current.isWord;
        }

        char c = word.charAt(index);


        // Check for dots edge-case
        if (c == '.') {
            for (TrieNode node : current.children.values()) {
                if (dfsSearch(index + 1, word, node)) {
                    return true;
                }
            }

            return false;
        }

        if (current.children.get(c) != null) {
            // We have a valid word, now we want to go through them
            current = current.children.get(c);
            return dfsSearch(index + 1, word, current);
        }

        return false;
    }
}
