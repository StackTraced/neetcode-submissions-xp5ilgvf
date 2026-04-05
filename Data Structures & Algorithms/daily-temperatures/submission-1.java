class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        // We want to store the index, so we get the value and distance
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            // check if NOT empty first and peek
            while (!stack.isEmpty() && (temperatures[stack.peek()] < temperatures[i])) {
                int pop = stack.pop();
                result[pop] = i - pop;
            }

            // Always add at the end
            stack.add(i);
        }


        return result;
    }

}
