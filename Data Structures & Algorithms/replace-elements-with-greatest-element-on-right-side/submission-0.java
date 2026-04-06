class Solution {
    public int[] replaceElements(int[] arr) {
        // Guarantee size one so
        int n = arr.length;

        int highestElement = arr[n - 1]; // Grab the last value
        // set the last value as -1
        arr[n - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            int tmp = Math.max(highestElement, arr[i]);

            arr[i] = highestElement; // Forced to use this, since -1 is smaller

            // is the current or old highest bigger?
            highestElement = Math.max(tmp, arr[i]);
        }

        return arr;
    }
}