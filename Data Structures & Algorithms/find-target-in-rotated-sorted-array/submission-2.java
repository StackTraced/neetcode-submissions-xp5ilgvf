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

            // Check if the left side is valid and contains the target
            if(nums[leftPointer] <= nums[mid]) {
                // We know the left side has a valid side

                // It's within this section
                if (nums[leftPointer] <= target && target <= nums[mid]) {
                    rightPointer = mid - 1;
                }
                // It isn't here and must be on the right side
                else {
                    leftPointer = mid + 1;
                }
            }

            // Right side is valid
            else if (nums[mid] <= nums[rightPointer]) {
                System.out.print("ENTERED");

                    if(nums[mid] <= nums[rightPointer] && target >= nums[mid]){
                        leftPointer = mid + 1;
                    } 

                    else {
                        rightPointer = mid - 1;
                    }
            }
        }

        return index;
    }
}
