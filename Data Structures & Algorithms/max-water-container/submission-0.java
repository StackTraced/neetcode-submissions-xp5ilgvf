class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int lp = 0;
        int rp = heights.length - 1;
        int area;

        while (lp < rp) {
            // calculate the sum and compare
            area = (rp - lp) * Math.min(heights[lp], heights[rp]);
            maxArea = Math.max(area, maxArea);
            
            // Move the pointers
            if (heights[lp] <= heights[rp]) {
                lp++;
            }
            else {
                rp--;
            }
        }

        return maxArea;
    }
}
