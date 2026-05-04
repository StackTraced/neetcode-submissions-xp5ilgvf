class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int bestArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            
            int currentHeight = (i == heights.length) ? 0 : heights[i]; 

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                   int tmpIndex = stack.pop();
                   int height = heights[tmpIndex];
                   int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                   bestArea = Math.max(bestArea, height * width);
            }

            stack.add(i);
        }
        
        return bestArea;
    }
}
