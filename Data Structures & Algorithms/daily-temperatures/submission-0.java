class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Greedy solution - Unoptimal
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            result[i] = find(temperatures, i);
        }

        return result;
    }


    private int find(int[] temperatures, int i) {
        int currValue = temperatures[i];

        for (int runner = i + 1; runner < temperatures.length; runner++) {
            if (temperatures[runner] > currValue) {
                return runner - i;
            }
        }

        return 0;
    }
}
