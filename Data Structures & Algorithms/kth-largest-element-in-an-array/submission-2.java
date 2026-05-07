class Solution {

    // What if we guarantee everything to the left of an index is smaller than it
    // and everything to the right is greater than it
    // Selection algorithm
    // We dont need to sort the entire array, we just need to find at which index, 
    // are the values below it are lower, and values above it are higher, if our final
    // pivot is k, thats our target


    public int findKthLargest(int[] nums, int k) {
        int lp = 0;
        int rp = nums.length - 1;
        int targetIndex = nums.length - k;

        // Our pivot point going to be the 0 index
        while (lp <= rp) {
            int pivotIndex = pivotIndex(lp, nums, rp);    

            if (pivotIndex == targetIndex) return nums[pivotIndex];

            if (pivotIndex > targetIndex) {
                //lp = pivotIndex + 1;
                rp = pivotIndex - 1;
            }

            else {
                lp = pivotIndex + 1;
                //rp = pivotIndex - 1;
            }
        }
        
        return -1;
    }

    private int pivotIndex(int lowerIndex, int[] nums, int upperIndex) {
        int boundary = lowerIndex;
        int pointer = boundary;

        // We want to swap the lowest to highest value
        swap(nums, lowerIndex, upperIndex);

        for (int i = lowerIndex; i < upperIndex; i++) {
            // Now nums[upperIndex] is our sorter

            // If its less than or equal than our nums[upperIndex], move the boundary
            // If it greater than, just move the pointer
            if (nums[i] <= nums[upperIndex]) {
                swap(nums, i, boundary);
                boundary++;
            }
        }
        
        
        swap(nums, upperIndex, boundary);
        return boundary; 
    }
 
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    

}
