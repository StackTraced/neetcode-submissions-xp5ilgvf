class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sort the array
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();

        backtrackSearch(result, candidates, target, 0, new ArrayList<>(), 0);


        return result;
    }


    private void backtrackSearch(List<List<Integer>> result, int[] candidates, int target, int index, List<Integer> current, int currentSum) {
        // Base Cases
        //if (currentSum > target ) return; // It's too big
        
        if (currentSum == target) {
            //System.out.println("INSIDE");
            // Need new ArrayList<>(), making a snapshot
            result.add(new ArrayList<>(current));
            return;
        }

        // Do we even need the index checker? The for loop just doesnt run anything
        // if(index >= candidates.length)

        // Our backtracking logic
        for (int i = index; i < candidates.length; i++) {
            // Quick optimize
            if (currentSum + candidates[i] > target) continue;

            if (i > index && candidates[i] == candidates[i - 1]) continue; 
            
            // Prevent dupes - We already computed it
            // Will deal with this later
            
            current.add(candidates[i]);
            //System.out.println(current.size());
            currentSum += candidates[i];

            backtrackSearch(result, candidates, target, i + 1, current, currentSum);
            
            

            currentSum -= candidates[i];
            // I think theres is a problem if we try .remove(x), but do we need the index or latest?
            current.remove(current.size() - 1);

            // We usually add something here
            // Go inside said function
            // remove it afterwards
        }
    }
}
