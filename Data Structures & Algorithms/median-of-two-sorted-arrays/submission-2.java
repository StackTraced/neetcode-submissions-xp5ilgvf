class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }

        int[] merged = mergedList(nums1, nums2);

        return computeMedian(merged);
    }

    // Need to abstract some logic to clear my head
    private double computeMedian(int[] arr) {
        if (arr.length % 2 == 0) {
            int a = arr.length / 2;
            int b = a - 1;
            return ((double)arr[a] + (double)arr[b]) / 2.0;
        }

        return arr[arr.length / 2];
    }

    // Combines the two list into a sorted array
    private int[] mergedList (int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];

        int numOneIndex = 0;
        int numTwoIndex = 0;
        int anchor = 0;

        while (numOneIndex < nums1.length && numTwoIndex < nums2.length) {
            if (nums1[numOneIndex] <= nums2[numTwoIndex]) {
                merged[anchor] = nums1[numOneIndex];
                numOneIndex++;
            }

            else {
                merged[anchor] = nums2[numTwoIndex];
                numTwoIndex++;
            }

            anchor++;
        }

        // NOT WORKING ONE OF THESE
        // One of them is empty or both
        while (numOneIndex < nums1.length) {
            merged[anchor] = nums1[numOneIndex];
            
            anchor++;
            numOneIndex++;
        }

        while (numTwoIndex < nums2.length) {
            merged[anchor] = nums2[numTwoIndex];
            
            anchor++;
            numTwoIndex++;
        }

        return merged;
    }
}
