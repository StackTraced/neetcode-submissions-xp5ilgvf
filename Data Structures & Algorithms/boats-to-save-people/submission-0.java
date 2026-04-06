class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int boats = 0;

        int lp = 0;
        int rp = people.length - 1;

        while (lp <= rp) {
            int sum = people[lp] + people[rp];

            if (sum <= limit) {
                lp++;
                rp--;
                boats++;
            }

            // here we assume too big? send big chungus
            else {
                rp--;
                boats++;
            }
        }

        return boats;
    }
}