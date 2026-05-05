class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a;
        int[] b;

        // We always want a to be the smallest
        if (nums1.length < nums2.length) {
            a = nums1;
            b = nums2;
        }
        else {
            a = nums2;
            b = nums1;
        }

        
        int half = ((a.length + b.length))/ 2;

        int lp = -1;
        int rp = a.length - 1;

        while (lp <= rp) {

            int aCut = lp + ((rp - lp) / 2);
            int sizeOfPartitionA = aCut + 1;

            int sizeOfPartitionB = half - sizeOfPartitionA;

            int bCut = sizeOfPartitionB - 1;

            int aLeft = aCut >= 0 ? a[aCut] : Integer.MIN_VALUE;
            
            int aRight = aCut + 1 < a.length ? a[aCut + 1] : Integer.MAX_VALUE;

            int bLeft = bCut >= 0 ? b[bCut] : Integer.MIN_VALUE;
            
            int bRight = bCut + 1 < b.length ? b[bCut + 1] : Integer.MAX_VALUE; 

            if (aLeft <= bRight && bLeft <= aRight) {
                int total = a.length + b.length;

                if (total % 2 == 0) {
                    

                    double highestLeft = Math.max(aLeft, bLeft);
                    System.out.println("HighestLeft: " + highestLeft);
                    double lowestRight = Math.min(aRight, bRight);
                    System.out.println("lowestRight: " + lowestRight);

                    //return highestLeft + ((lowestRight - highestLeft) / 2.0);
                    return (highestLeft + lowestRight) / 2.0;
                }

                return Math.min(aRight, bRight);
            }

            if (bLeft > aRight) {
                lp = aCut + 1;
            }
            else {
                rp = aCut - 1;
            }
        }

        return -1.0;
    }
}