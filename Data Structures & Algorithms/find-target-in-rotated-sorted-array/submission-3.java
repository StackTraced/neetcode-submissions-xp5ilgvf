class Solution {
    public int search(int[] nums, int target) {
        // Prevent unneeded computations
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        
        int index = -1;
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        int mid = 0;

        while(leftPointer <= rightPointer) {
            mid = (leftPointer + rightPointer) / 2;

            if (nums[mid] == target) {
                return mid;
            }    
            else if(nums[leftPointer] == target){
                return leftPointer;
            }
            else if(nums[rightPointer] == target) {
                return rightPointer;
            }

            if (nums[leftPointer] <= nums[mid]) {
                if (nums[leftPointer] <= target && target < nums[mid]) {
                    rightPointer = mid - 1;
                } else {
                    leftPointer = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[rightPointer]) {
                    leftPointer = mid + 1;
                } else {
                    rightPointer = mid - 1;
                }
            }
        }
        return index;
    }
}
