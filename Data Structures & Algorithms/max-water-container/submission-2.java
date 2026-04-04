class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;

        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        int area;

        while (leftPointer < rightPointer) {
            area = (rightPointer - leftPointer) * (Math.min(heights[leftPointer], heights[rightPointer]));
            maxArea = Math.max(maxArea, area);

            if (heights[leftPointer] <= heights[rightPointer]) {
                leftPointer++;
            }
            else {
                rightPointer--;
            }
        }

        return maxArea;
    }
}
