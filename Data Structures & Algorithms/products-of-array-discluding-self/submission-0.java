class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftPass = new int[nums.length];
        leftPass[0] = 1;

        int[] rightPass = new int[nums.length];
        rightPass[nums.length - 1] = 1;


        int[] result = new int[nums.length];

        for(int i = 1; i < nums.length; i++){
            int prev = nums[i - 1];
            int prefLeft = leftPass[i - 1];
            leftPass[i] = prev * prefLeft;
        }

        for(int i = nums.length - 2; i >= 0; i--) {
            int prev = nums[i + 1];
            int prevRight = rightPass[i + 1];
            rightPass[i] = prev * prevRight;
        }

        for(int i = 0; i < nums.length; i++) {
            result[i] = leftPass[i] * rightPass[i];
        }
        return result; 
    }
}  
