class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int index = -1;

        while (left <= right) {
            // find the mid so we can search
            int mid = (left + right) / 2;

            // check to see if mid is our target
            if (nums[mid] == target) {
                index = mid;
                break;
            }

            // Maybe other ifs to speed it up? Although, not binaray
            if (nums[left] == target) {
                index = left;
                break;
            }

            if (nums[right] == target) {
                index = right;
                break;
            }

            // Find which side is sorted, the left or right?
            if (nums[left] <= nums[mid]) { // We can assume the left side is sorted

                // Now we need to see if our target lives in here?

                // If our target lives in here, discard the right side
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                }

                // If our target doesn't live in here, discard this entire section
                else {
                    left = mid + 1;
                }
            }

            // We can assume the right side is sorted
            else { // But is our target in here?
                if(target >= nums[mid] && target <= nums[right]) { // it's in here
                    left = mid + 1;
                }
                else { // we have a sorted list and not in here, discard it
                    right = mid - 1;
                }
            }
        }

        return index;
    }
}
