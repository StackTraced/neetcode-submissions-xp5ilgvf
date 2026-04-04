class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Rows
        for (int r = 0; r < 9; r++) {
            Set<Character> vision = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.' && vision.contains(board[r][c])) {
                    return false;
                }
                if (board[r][c] != '.') {
                    vision.add(board[r][c]);
                }
            }
        }

        // Cols
        for (int c = 0; c < 9; c++) {
            Set<Character> vision = new HashSet<>();
            for (int r = 0; r < 9; r++) {
                if (board[r][c] != '.' && vision.contains(board[r][c])) {
                    return false;
                }
                if (board[r][c] != '.') {
                    vision.add(board[r][c]);
                }
            }
        }
        // 0, 3, 6
        for(int r = 0; r < 9; r+=3) {

            for(int c = 0; c < 9; c+=3) {
                if (!isValid(board, r, r + 3, c, c + 3)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int rowMin, int rowMax, int colMin, int colMax) {
        Set<Character> vision = new HashSet<>();

        for (int row = rowMin; row < rowMax; row++) {
            
            for (int col = colMin; col < colMax; col++) {
                if (board[row][col] != '.' && vision.contains(board[row][col])) {
                    return false;
                }
                vision.add(board[row][col]);
            }
        }

        return true;
    }
}
