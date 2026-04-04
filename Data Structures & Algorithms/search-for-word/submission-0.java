class Solution {
    public boolean exist(char[][] board, String word) {

        // Our starter
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (search(x, y, board, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }


    // Position to keep track of what char we are looking for
    private boolean search(int x, int y, char[][] board, int position, String word) {
        // We only increment position if we find it and prevent OOB from char below
        if (position >= word.length()) {
            return true;
        }

        // Base Case to prevent Out of Bounds
        // would need the x and y
        // would need the board size and length to determine
        // board.length (row) board[0].length (col)
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }

        // This is a burned piece and verified its in bounds
        if (board[x][y] == '#' || board[x][y] != word.charAt(position)) {
            return false;
        }

        // Here we can assume it is the correct char
        char tmp = board[x][y];
        board[x][y] = '#'; // burn it
        position++;
        // do something

        // Need to store it so we can run the code below
        boolean result = 
                search(x + 1, y, board, position, word) ||
                search(x - 1, y, board, position, word) ||
                search(x, y + 1, board, position, word) ||
                search(x, y - 1, board, position, word);

        //revert
        board[x][y] = tmp;

        return result;

    }
}
