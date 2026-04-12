class Solution {
    public boolean isHappy(int n) {
        
        HashSet<Integer> seen = new HashSet<>();

        while(true) {
            n = getTheValue(n);
            if (n == 1) return true;

            if (seen.contains(n)) return false;

            seen.add(n);
        }

        // True until we find a contradiction
        //return true;
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
