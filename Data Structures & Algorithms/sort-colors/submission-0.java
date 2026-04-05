class Solution {
    public void sortColors(int[] nums) {
        int numberOfZeros = 0;
        int numberOfOnes = 0;
        int numberOfTwos = 0;


        for(int n: nums) {
            if (n == 0) numberOfZeros++;
            else if (n == 1) numberOfOnes++;
        }

        // now that we have the count
        int index = 0;
        while(index < nums.length) {
            if (numberOfZeros > 0) {
                nums[index] = 0;
                numberOfZeros--;
                index++;
            }
            else if (numberOfOnes > 0) {
                nums[index] = 1;
                numberOfOnes--;
                index++;
            }
            // Can assume nothing else remains
            else {
                nums[index] = 2;
                index++;
            }
        }
    }
}