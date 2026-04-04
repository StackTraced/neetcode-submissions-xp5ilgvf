class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;

        for (int n: nums) {
            total += n;
        }

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // total = leftSide + nums[i] + rightSide
            // because the pivot isn't included in the sums
            // perform algebra to get rightSide alone
            // total - leftSide - nums[i] = rightSide
            rightSum = total - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }


        return -1;
    }
}