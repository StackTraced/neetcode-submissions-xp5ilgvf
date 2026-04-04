class Solution {
    public int findMin(int[] nums) {
        
        // Making this our impossible value
        // constraint mentions 1000
        int smallestNumber = 1001;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // Check to see if the left side is "proper"
            if (nums[left] <= nums[mid]) {
                smallestNumber = Math.min(smallestNumber, nums[left]);
                left = mid + 1;
            }

            // We can assume the right side is proper?? - Maybe a wrong assumption...
            // Maybe should put another if statement and the else can be just mid...
            else {
                smallestNumber = Math.min(smallestNumber, nums[mid]);
                right = mid - 1;
            }
        }


        return smallestNumber;

    }
}
