class Solution {
    public void rotate(int[][] matrix) {
        // Get the length of the matrix
        int length = matrix.length;
        
        int tmp;
        
        // Our transpose, diagonal
        for(int x = 0; x < length; x++) {
            for(int y = x + 1; y < length; y++) {
                tmp = matrix[x][y]; // Place this into [y][x]
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = tmp;
            }
        }

        // Then we swap them - Going to be fancy and use two-pointers
        for(int x = 0; x < length; x++) {
            
            int lp = 0;
            int rp = length - 1;

            // i dont think this is needed, but cant think of a better idea atm
            while (lp < rp) { // if they intersect, we dont swap them
                // x is constant
                int t = matrix[x][lp];
    
                matrix[x][lp] = matrix[x][rp];
                matrix[x][rp] = t;

                lp++;
                rp--;
            }
        }
    }
}
