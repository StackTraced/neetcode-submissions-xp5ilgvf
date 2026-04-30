class PrefixTree {

    private TrieNode root;

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char c: word.toCharArray()) {
            // Check if it exist or grab it, using new method we learned
            // computeIfAbsent
            current = current.children.computeIfAbsent(c, key -> new TrieNode());
        }

        current.isWord = true;
    }

    // Search the trie, and once we hit the end, check the boolean
    public boolean search(String word) {
        TrieNode current = root;
        
        for (char c: word.toCharArray()) {
            if (current.children.get(c) == null) {
                return false;
            }

            current = current.children.get(c);
        }

        // End of the loop
        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        
        for (char c: prefix.toCharArray()) {
            // If it doesn't exist, return false
            if (current == null || current.children.get(c) == null) {
                return false;
            }

            current = current.children.get(c);
        }

        return true;
    }
}
