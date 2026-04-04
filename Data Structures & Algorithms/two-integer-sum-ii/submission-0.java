class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;

        int sum;

        while (leftPointer < rightPointer) {
            sum = numbers[leftPointer] + numbers[rightPointer];


            // The sum is the target
            if (sum == target) {
                return new int[]{leftPointer + 1, rightPointer + 1};
            }

            // Too small
            else if (sum < target) {
                leftPointer++;
            }

            // Else too big
            else {
                rightPointer--;
            }
            
        }

        return new int[]{leftPointer, rightPointer};
    }
}
