class Solution {
    public int trap(int[] height) {
        int lp = 0;
        int rp = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int rainWater = 0;
        int lowerBoundary;
        int sum;

        while (lp < rp) {
            // Compute the new max - trying to bound it
            leftMax = Math.max(leftMax, height[lp]);
            rightMax = Math.max(rightMax, height[rp]);

            // Determine which one is smaller to do the math

            // Left side is the bottle neck
            if (leftMax <= rightMax) {
                sum = leftMax - height[lp];
                if (sum > 0) rainWater += sum;
                lp++;
            }

            // Right side is smaller and the bottle neck
            else {
                sum = rightMax - height[rp];
                if (sum > 0) rainWater += sum;
                rp--;
            }
        }


        return rainWater;

    }
}
