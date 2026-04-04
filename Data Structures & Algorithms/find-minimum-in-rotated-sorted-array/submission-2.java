class Solution {
    public int findMin(int[] nums) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        int currentMin = Integer.MAX_VALUE;

        while(leftPointer <= rightPointer) {
            int mid = (leftPointer + rightPointer) / 2;

            // If the left side is sorted
            if (nums[leftPointer] <= nums[mid]) {
                currentMin = Math.min(currentMin, nums[leftPointer]);
                leftPointer = mid + 1;
            }

            // If the right side is sorted
            else if(nums[mid] <= nums[rightPointer]) {
                currentMin = Math.min(currentMin, nums[mid]);
                rightPointer = mid;
            }
        }

        return currentMin;
    }
}
