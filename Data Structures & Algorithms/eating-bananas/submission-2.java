class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int bestRate = Integer.MAX_VALUE;

         // find the highest
         int right = 0;

         for (int i: piles) {
            right = Math.max(right, i);
         }

         int left = 1;
         int mid;
         

         while (left <= right) {
            mid = ((right - left) / 2) + left; // problem
            // right = right + low - low // add a zero
            // right + low - low + low -> (right + 2low - low) / 2 -> (right - low) / 2 + low
            
            int maxHours = 0;

            for (int i: piles) {
                int hours = i / mid;
                if ((i % mid) != 0) {
                    hours++;
                } 

                maxHours+= hours;
            }

            if (maxHours <= h) {
                    bestRate = Math.min(bestRate, mid);
                    right = mid - 1;
            } else {
                left = mid + 1;
            }
         }
        


        return bestRate;
    }
}
