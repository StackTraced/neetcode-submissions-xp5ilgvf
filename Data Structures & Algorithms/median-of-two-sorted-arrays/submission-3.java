class Solution {

    // We now know both have values, and nums1 is the smaller one
    // If we have two arrays:
    // suppose 7 in total, to find the median we need the first 3 lowest values + next index
    // suppose 8 in total, to find the median we need the first 4 lowest elements and next value to compute
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1;
        int[] b = nums2;

        // We need the total, since we are going to partition the array
        // If we merge array [1,2,3] and [3,4] -> [1,2,3,3,4]
        // The total is 5. Half in Java is 2
        // [1,2] -> next value is the median

        // We need the total, since we are going to partition the array
        // If we merge array [1,2,3] and [3,4,5] -> [1,2,3,3,4,5]
        // The total is 6. Half in Java is 3
        // [1,2,3] -> next value plus the last value divide by 2 is the median
        int total = a.length + b.length;

        // If we had an odd number array size -> 7
        // We want the left side to have 4, to easily grab the median
        // 4 + 3 -> 7
        // 7 + 1 -> 8 / 2 -> 4
        
        // If we had an even number array size -> 8
        // ! In Java, int truncate down, "rounds down"
        // 4 + 4 -> 8
        // 8 + 1 -> 9 / 2 -> 4
        int half = (total + 1) / 2;
        
        // We want the a array to be smaller or equal to b
        if (b.length < a.length) {
            int[] tmp = a;
            a = b;
            b = tmp;
        }

        // These values are going to work on the 'a' array to grab a partition
        // Whatever is left over, is how many we grab from the 'b' array
        int lp = 0;
        int rp = a.length;
        
        // A result will happen, but can't let an infinite loop happen
        while (lp <= rp) {
            
            // This is just us finding the mid for the 'a' array
            // Once we find that amount, we want the 'b' array to total us to the half value
            int cutA = lp + ((rp - lp) / 2);
            int cutB = half - cutA;

            // We want to grab the partition, but if they are out of bounds....
            // Just like a DFS algorithm, how we check if the index are legal
            int Aleft   = cutA > 0           ? a[cutA - 1]   : Integer.MIN_VALUE;
            int Aright  = cutA < a.length    ? a[cutA]       : Integer.MAX_VALUE;
            
            
            int Bleft   = cutB > 0           ? b[cutB - 1]   : Integer.MIN_VALUE;
            int Bright  = cutB < b.length    ? b[cutB]       : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {

                if (total % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                }

                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } 

            if (Aleft > Bright) {
                rp = cutA - 1;
            } 
            else {
                lp = cutA + 1;
            }
        }

        // Will never hit this, unless we have an invalid array
        return -1;      
    }
}
