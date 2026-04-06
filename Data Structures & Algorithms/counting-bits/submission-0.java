class Solution {
    public int[] countBits(int n) {
        int [] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            result[i] = countInternalBits(i);
        }

        return result;
    }

    private int countInternalBits(int n) {
        int sum = 0;

        while (n != 0) {
            n = n & (n - 1);
            sum++;
        }

        return sum;
    }
}
