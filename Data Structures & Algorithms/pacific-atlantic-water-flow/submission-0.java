class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for (int c = 0; c < heights[0].length; c++) {
            dfs(pacific, 0, c, heights);
            dfs(atlantic, heights.length - 1, c, heights);
        }

        for (int r = 0; r < heights.length; r++) {
            dfs(pacific, r, 0, heights);
            dfs(atlantic, r, heights[0].length - 1, heights);
        }


        for(int row = 0; row < heights.length; row++) {
            for(int col = 0; col < heights[0].length; col++) {
                // Check if both are true
                if (atlantic[row][col] && pacific[row][col]) {
                    result.add(new ArrayList<>(Arrays.asList(row, col)));
                }

            }
        }

        return result;
    }

    // Void, since we are mutating a chart - passing in an ocean
    private void dfs(boolean[][] ocean, int row, int col, int[][] heights) {
        ocean[row][col] = true;

        for(int[] i: pos) {
            int nr = row + i[0];
            int nc = col + i[1];

            if (invalidCords(heights, nr, nc)) continue;

            //System.out.printf("Setting up Ints: Row: (%d) Col: (%d)\n", row, col);
            // We can assume we have valid cords
            int currentHeight = heights[row][col];
            int potentialHeight = heights[nr][nc];

            if(ocean[nr][nc]) continue;

            //if (currentHeight >= potentialHeight) {
            if (potentialHeight >= currentHeight) {
                //System.out.printf("Going inside: Row: (%d) Col: (%d)\n", row, col);
                dfs(ocean, nr, nc, heights);
            }
        }
    }

    private boolean invalidCords(int[][] heights, int row, int col) {
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length) {
            //System.out.printf("Invalid Cords: Row: (%d) Col: (%d)\n", row, col);
            return true;
        }

        //System.out.printf("Valid Cords: Row: (%d) Col: (%d)\n", row, col);
        return false;
    }

    private int[][] pos = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };
}
