class Solution {
    public int singleNumber(int[] nums) {
        int solution = 0;

        for (int n: nums) solution ^= n;

        return solution;
    }
}
