class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        // First find where they intersect
        
        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        } while(slow != fast);

        // We have found where they intersect
        int start = 0;

        while (start != slow) {
            start = nums[start];
            slow = nums[slow];
        }
        
        return start;

        
    }
}
