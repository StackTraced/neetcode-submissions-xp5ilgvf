class Solution {
    public int pivotIndex(int[] nums) {
        
        int pivot = -1;

        for (int i = 0; i < nums.length; i++) {
            if (computeLeft(i - 1, nums) == computeRight(i + 1, nums)) {
                return i;
            }
        }


        return pivot;
    }


    private int computeLeft(int i, int[] nums) {
        int sum = 0;

        if (i < 0) {
            return sum;
        }

        for (int x = i; x >= 0; x--) {
            sum += nums[x];
        }

        return sum;
    }   

    private int computeRight(int i, int[] nums) {
        int sum = 0;

        if (i > nums.length) {
            return sum;
        }

        for (int x = i; x < nums.length; x++) {
            sum += nums[x];
        }

        return sum;
    }
}