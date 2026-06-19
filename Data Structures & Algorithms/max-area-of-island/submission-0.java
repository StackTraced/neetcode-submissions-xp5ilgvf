class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, search(grid, r, c));
                }
            }
        }   


        return maxArea;
    }

    int[][] pos = new int[][]{
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };


    private int search(int[][] grid, int r, int c) {
        // Check to see if the tiles are legal
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;

        int localSum = 0;

        System.out.printf("Inside tile r:%d c:%d\n", r, c);

        // Dont think its that easy
        for(int[] i: pos) {
            localSum += search(grid, r + i[0], c + i[1]);
        }

        return localSum + 1;
    }
}
