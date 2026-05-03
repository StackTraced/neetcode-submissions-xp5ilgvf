class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int area = 0;

        // From left to right
        int anchor = 0;

        // This method will allow us to check as we grow
        while (anchor < heights.length) {

            int lowestHeight = heights[anchor];

            for (int i = anchor; i < heights.length; i++){
                int distance = i - anchor + 1;

                lowestHeight = Math.min(lowestHeight, heights[i]);

                // Check with the distance
                area = Math.max(area, lowestHeight * distance);
            }

            anchor++;
        }

        return area;
    }
}
