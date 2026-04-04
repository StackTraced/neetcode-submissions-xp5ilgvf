class Solution {
    public int search(int[] nums, int target) {
        int leftSide = 0;
        int rightSide = nums.length - 1;
        int index = -1;

        int mid;
        int value;

        while (leftSide <= rightSide) {
            mid = ((rightSide - leftSide) / 2) + leftSide;
            value = nums[mid];

            if (value == target) {
                return mid;
            } 
            // Too big
            else if (target > value) {
                leftSide = mid + 1;
            }
            
            // Too small
            else {
                rightSide = mid - 1;
            }
            
        }

        return index;
    }
}
