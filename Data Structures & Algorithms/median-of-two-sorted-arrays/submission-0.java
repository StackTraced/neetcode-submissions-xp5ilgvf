class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }

        // Brute Force Solution before we optimize it
        List<Integer> list = new ArrayList<>();

        for (int i: nums1) {
            list.add(i);
        }

        for (int i: nums2) {
            list.add(i);
        }

        if (list.size() == 1) {
            return list.get(0);
        }

        // Collections.sort() does exist
        list.sort((a, b) -> Integer.compare(a, b));

        // Even amount
        if (list.size() % 2 == 0) {
            int a = list.get(list.size() / 2);
            int b = list.get((list.size() / 2) - 1);
            return ((double) a + (double) b) / 2.0;
         }

        // We gurantee an odd amount
        return list.get(list.size() / 2);
    }
}
