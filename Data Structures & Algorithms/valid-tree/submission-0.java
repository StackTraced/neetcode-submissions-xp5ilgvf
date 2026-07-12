class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        // There is a better way of doing this, but writing it how I would
        for(int i = 0; i < n; i++) {
            Set<Integer> localSet = new HashSet<>();
            localSet.add(i);
            map.put(i, localSet);
        }

        // Now that we have a relationship
        for(int[] i: edges) {
            if (!connect(i[0], i[1], map)) return false;        
        }

        // If the size of the array doesn't match the n size, all the nodes, it doesn't meet all
        return map.get(0).size() == n;
    }

    private boolean connect(int a, int b, HashMap<Integer, Set<Integer>> map) {
        if (connected(a, b, map)) return false;

        // Grab a's list and we can merge it directly
        Set<Integer> merged = map.get(a);


        // We want to grab all of the values in b, and iterate over them, by transitive
        // properly, everything in here has access to the merged
        Set<Integer> bList = map.get(b);

        merged.addAll(bList);

        // We have manipulated a's list

        

        for(int i: bList) {
            map.put(i, merged);
        }



        return true;
    }


    private boolean connected(int a, int b, HashMap<Integer, Set<Integer>> map) {
        Set<Integer> localSet = map.get(a);

        return localSet.contains(a) && localSet.contains(b);
    }


}
