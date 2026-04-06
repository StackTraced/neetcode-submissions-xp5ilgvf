class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while(n != 0) { // We are given a bit, so go until '0'
            if ((n & 1) == 1) count++;
            n = n >> 1; // shift it by one
        }

        return count;
    }
}
