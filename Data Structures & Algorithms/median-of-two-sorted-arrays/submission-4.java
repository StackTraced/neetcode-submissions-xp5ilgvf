class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // ===== Phase 1: Setup =====
        // Ensure 'a' is the shorter array. Binary searching the smaller one
        // keeps the search range tight and avoids out-of-bounds on cutB.
        int[] a = nums1.length <= nums2.length ? nums1 : nums2;
        int[] b = nums1.length <= nums2.length ? nums2 : nums1;

        int total = a.length + b.length;

        // 'half' = how many elements land on the LEFT side of the combined cut.
        // Using (total + 1) / 2 puts the median (or the lower of the two middles
        // for even totals) on the left, so we can read it off as max(Aleft, Bleft)
        // without branching on parity for the position.
        int half = (total + 1) / 2;

        // ===== Phase 2: Binary search the cut position in 'a' =====
        // The "knob" we turn is how many elements from 'a' go to the left side.
        // Once we pick cutA, cutB is forced by the size constraint.
        int lp = 0;
        int rp = a.length;

        while (lp <= rp) {
            int cutA = lp + (rp - lp) / 2;
            int cutB = half - cutA;

            // ===== Phase 3: Read the four boundary values =====
            // Sentinels handle the edges: if a side is empty, treat its
            // boundary as -∞ on the left or +∞ on the right so the
            // cross-checks below pass automatically.
            int Aleft  = cutA > 0        ? a[cutA - 1] : Integer.MIN_VALUE;
            int Aright = cutA < a.length ? a[cutA]     : Integer.MAX_VALUE;
            int Bleft  = cutB > 0        ? b[cutB - 1] : Integer.MIN_VALUE;
            int Bright = cutB < b.length ? b[cutB]     : Integer.MAX_VALUE;

            // ===== Phase 4: Validate and act =====
            // Valid cut: every left-side value <= every right-side value.
            // Only need the cross-checks; within-array order is already sorted.
            if (Aleft <= Bright && Bleft <= Aright) {
                // Odd total: median sits at the right edge of the left side.
                if (total % 2 != 0) return Math.max(Aleft, Bleft);
                // Even total: average the two middles straddling the cut.
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            }

            // Invalid cut. Shift cutA in the direction that fixes the violation:
            // - Aleft too big: too many 'a' elements on the left, move cutA down.
            // - Otherwise:     too few 'a' elements on the left, move cutA up.
            if (Aleft > Bright) rp = cutA - 1;
            
            else                lp = cutA + 1;
        }

        return -1; // Unreachable for valid input.
    }
}
