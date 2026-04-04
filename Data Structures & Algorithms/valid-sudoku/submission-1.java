class Solution {
    // We don't count dots?
    public boolean isValidSudoku(char[][] board) {

        Set<Character> seen = new HashSet<>(); // Creating a single set to not repeat
        // Check all rows
        for (int x = 0; x < board.length; x++) {

            for (int y = 0; y < board.length; y++) {
                if (board[x][y] == '.') continue; // we don't care
                if (seen.contains(board[x][y])) return false;
                seen.add(board[x][y]);
            }
            // Reset the seen
            seen.clear();
        }

        // Check all cols
        for (int y = 0; y < board.length; y++) {

            for (int x = 0; x < board.length; x++) {
                if (board[x][y] == '.') continue; // we don't care
                if (seen.contains(board[x][y])) return false;
                seen.add(board[x][y]);
            }
            // Reset the seen
            seen.clear();
        }
        

        for(int x = 0; x < board.length; x+=3) {
            for(int y = 0; y < board.length; y+=3) {
                if (!gridChecker(x,x+3,y,y+3,board)) {
                    return false;
                }
            }
        }

        return true;

    }


    private boolean gridChecker(int xStart, int xFin, int yStart, int yFinish, char[][]board) {
        Set<Character> localSeen = new HashSet<>();

        for(int x = xStart; x < xFin; x++) {

            for(int y = yStart; y < yFinish; y++) {
                if (board[x][y] == '.') continue; // we don't care
                if (localSeen.contains(board[x][y])) return false;
                localSeen.add(board[x][y]);
            }
        }

        return true;
    }
}
