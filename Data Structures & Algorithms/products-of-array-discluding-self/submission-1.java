class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] solution = new int[nums.length];

        int[] firstPass = new int[nums.length];
        firstPass[0] = 1;

        for (int a = 1; a < firstPass.length; a++) {
            firstPass[a] = firstPass[a - 1] * nums[a- 1];
        }

        int[] secondPass = new int[nums.length];
        secondPass[secondPass.length - 1] = 1;

        for (int b = secondPass.length - 2; b >= 0; b--) {
            secondPass[b] = secondPass[b + 1] * nums[b + 1];
        }


        for(int i = 0; i < solution.length; i++) {
            solution[i] = firstPass[i] * secondPass[i];
        }

        return solution;
    }
}  
