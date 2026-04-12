class Solution {
    public boolean isHappy(int n) {
        // Linked List Cycle - Slow and Fast
        int slow = n;
        int fast = getTheValue(n);

        while (fast != 1 && fast != slow) {
            slow = getTheValue(slow);
            fast = getTheValue(getTheValue(fast));
        }
        // It stopped cause fast equaled 1 or equaled slow
        return fast == 1;
    }    

    private int getTheValue(int n) {
        // We want to chop it down and grab its value
        int sum = 0;


        while (n > 0) {
            int value = n % 10;
            sum += value * value;
            n /= 10;
        }

        return sum;
    }
}
