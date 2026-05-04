class Solution {
    public int majorityElement(int[] nums) {
        
        int threshHold = nums.length / 2;

        int candidate = 0;
        int counter = 0;


        for (int i: nums) {
            if (counter == 0) {
                candidate = i;
            }

            counter += (i == candidate) ? 1 : -1;
        }
        
        

        return candidate;
    }
}