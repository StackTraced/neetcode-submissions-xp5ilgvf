class Solution {

    private Trie root = new Trie();

    private List<String> result;

    private static class Trie {
        HashMap<Character, Trie> children = new HashMap<>();
        boolean isWord = false;
        String word;
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
        // If its a word, we add it to the list
        if (node.isWord) {
            result.add(node.word);
            node.isWord = false;
        }

        // Now, we check if the move is legal
        // The || lets us check if its a valid row and col, before checking if it's an '#'
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '#') {
            return; // Illegal move
        }

        //System.out.println("TEST");

        // Before we even attempt to go any deeper, does the current char even exist in the trie?
        if (!node.children.containsKey(board[row][col])) {
            return;
        }
        // Is it the logic above
        //System.out.println("AFTER");

        // Now that we know we have a legal move, we can access it
        char tmp = board[row][col];
        board[row][col] = '#';
        
        // Save it 
        Trie tmpNode = node.children.get(tmp);


        for (int[] i: dirs) {
            dfsSearch(tmpNode, row + i[0], col + i[1], board);
        }

        board[row][col] = tmp;
    }
}
