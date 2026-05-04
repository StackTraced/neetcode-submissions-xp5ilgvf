class Solution {
    public int removeElement(int[] nums, int val) {

        
        int anchor = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] != val) {
                nums[anchor] = nums[i];
                anchor++;
            }
        }

        return anchor;
    }
}