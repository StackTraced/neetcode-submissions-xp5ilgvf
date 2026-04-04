class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] solution = new int[nums.length];
        solution[0] = 1;

        for (int fp = 1; fp < nums.length; fp++) {
            solution[fp] = solution[fp - 1] * nums[fp - 1];
        }
        
        int suffix = 1;

        // Build it up

        for (int i = nums.length - 2; i >= 0; i--) {
            suffix = suffix * nums[i + 1];
            solution[i] = solution[i] * suffix;
        }

        return solution;
    }
}  
