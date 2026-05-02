class Solution {

    private Trie root;

    private List<String> result;

    private static class Trie {
        HashMap<Character, Trie> children = new HashMap<>();
        boolean isWord = false;
        String word;

        boolean avoid = false;
    }

    private int[][] dirs = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    private void buildTrie(String[] words) {

        for (String s: words) {

            Trie current = root;

            for (char c: s.toCharArray()) {
                current = current.children.computeIfAbsent(c, key -> new Trie());
            }

            current.isWord = true;
            current.word = s;
        }

    }

    public List<String> findWords(char[][] board, String[] words) {
        root = new Trie();
        result = new ArrayList<>();

        buildTrie(words);
        
        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[0].length; col++) {
                
                // We want to see if the root contains the char
                char c = board[row][col];
                if (root.children.containsKey(c)) {
                    dfsSearch(root, row, col, board);
                }
            }
        }


        return result;
    }

    private void dfsSearch(Trie node, int row, int col, char[][] board) {

        // Check to see if the current tile is legal
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '#') {
            return; // Illegal move
        }

        // Does node even contain a trie with the current tile?
        char ch = board[row][col];
        if (!node.children.containsKey(ch)) {
            return;
        }

        // We confirmed node has a children with the current tile, grab it
        Trie tmpNode = node.children.get(ch);

        // If its a word, we add it to the list
        if (tmpNode.isWord) {
            result.add(tmpNode.word);
            tmpNode.isWord = false;
        }

        board[row][col] = '#';
        
        for (int[] i: dirs) {
            dfsSearch(tmpNode, row + i[0], col + i[1], board);
        }

        board[row][col] = ch;

        if (tmpNode.children.isEmpty() && !tmpNode.isWord) {
            node.children.remove(ch);
        }
    }

    
}
