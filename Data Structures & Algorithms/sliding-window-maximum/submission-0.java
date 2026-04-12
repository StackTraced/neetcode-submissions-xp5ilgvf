class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        int anchor = 0;
        int runner = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        while (runner < nums.length) {
            // Check if the left most is smaller then correct need a montonic deque
            while (!dq.isEmpty() && nums[runner] > nums[dq.peekLast()]) {
                dq.removeLast();
            }



            dq.addLast(runner);

            // Window too big — advance anchor
            if (runner - anchor + 1 > k) {
                anchor++;
            }

            // Deque front is outside current window — remove it
            if (!dq.isEmpty() && dq.peekFirst() < anchor) {
                dq.removeFirst();
            }

            if (runner - anchor + 1 == k) {
                result[anchor] = nums[dq.peekFirst()];
            }

            runner++;
        }

        return result;
    }
}
