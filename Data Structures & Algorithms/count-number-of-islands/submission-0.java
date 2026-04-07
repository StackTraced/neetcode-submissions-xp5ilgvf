class Solution {
    public int numIslands(char[][] grid) {
        
        int numberOfIslands = 0;

        int[][] movements = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == '1') {
                    numberOfIslands++;
                    dfs(grid, x, y, movements);
                }
            }
        }

        return numberOfIslands;
    }

    // Pass the grid, since we will burn them
    // pass the cords
    // Movements, to not remake them
    // 
    private void dfs(char[][] grid, int x, int y, int[][] movements) {
        // Verify the x and y are valid
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }

        if (grid[x][y] == '0') return;

        // We want to burn the tiles
        grid[x][y] = '0';

        for (int i = 0; i < movements.length; i++) {
            dfs(grid, x + movements[i][0], y + movements[i][1], movements);
        }
    }
}
