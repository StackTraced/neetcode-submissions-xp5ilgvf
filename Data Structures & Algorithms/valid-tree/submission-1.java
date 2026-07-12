class Solution {
    // Union find version, no looking at the syntax, need to see if we can dervive it
    // myself
    public boolean validTree(int n, int[][] edges) {
        // Replace the HashMap with array
        int[] map = new int[n];
        
        // Mentally Equivalent to HashMap<Integer, Set<Integer>> map...
        // 0: {0}
        // 1: {1}
        // 2: {2}
        // 3: {3}
        // 4: {4}
        // All of them are pointing at each other

        for(int i = 0; i < n; i++) {
            map[i] = i;
        }

        for (int[] i: edges) {
            if (!union(i[0], i[1], map)) return false;
        }

        int anchor = find(0, map);
        for (int i = 1; i < map.length; i++) {
            if (find(i, map) != anchor) return false;
        }


        return true;

    }


    private int find(int x, int[] map) {
        if (map[x] == x) return x;

        return find(map[x], map);
    }

    private boolean union(int a, int b, int[] map) {
        int aBase = find(a, map);
        int bBase = find(b, map);

        if (aBase == bBase) return false;

        // Justify why we write it one way
        // We want to connect them, we currently have the base for both of them, 
        // the "lowest" level, we do the lowest level
        // a: We want to conenct b here, by picking this, we aren't just placing it
        // randomly in the middle of the chain
        // the key word, the graph is "undirected", so if we can conenct to one, we can conenct to it
        // We are picking b, cause we need to pick one anyway

        //map[aBase] = bBase;
        // or
        map[bBase] = aBase;

        return true;
    }
}
