class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        findCombination(candidates, target, 0, current, result, 0, used);

        return result;

    }

    private void findCombination(int[] candidates, int target, int sum, List<Integer> current, List<List<Integer>> result, int index, boolean[] used) {
        // We don't do anything here
        if (sum > target) {
            return;
        }

        if (sum == target) {
            result.add(new ArrayList(current));
            return;
        }

        // Here we can assume we haven't hit our target, so we add to it
        for (int i = index; i < candidates.length; i++) {
            // Try a simple before check
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false){
                // Loops to the for statement and does our checker
                continue;
            }
            

            // For backtracking, always same three patterns

            // Add to a list
            used[i] = true;
            current.add(candidates[i]);
            sum += candidates[i];

            // Search
            findCombination(candidates, target, sum, current, result, i + 1, used);

            // Remove
            current.remove(current.size() - 1);
            sum -= candidates[i];
            used[i] = false;
        }

    }
}
