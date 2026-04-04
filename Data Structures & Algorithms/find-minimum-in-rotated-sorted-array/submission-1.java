class Solution {
    public int findMin(int[] nums) {
        int currentMin = Integer.MAX_VALUE;
        int leftPointer = 0;
        int rightPointer = nums.length - 1;

        //int counter = 0;

        while(leftPointer <= rightPointer) {
            int mid = (leftPointer + rightPointer) / 2;
            //counter++;

            // Check if the left side is 'proper'
            if (nums[leftPointer] <= nums[mid]) {
                currentMin = Math.min(currentMin, nums[leftPointer]);
                leftPointer = mid + 1;
            }

            else if(nums[mid] <= nums[rightPointer]) {
                currentMin = Math.min(currentMin, nums[mid]);
                rightPointer = mid - 1;
            }
        }

        //System.out.println("Counter: " + counter);

        return currentMin;
    }
}
