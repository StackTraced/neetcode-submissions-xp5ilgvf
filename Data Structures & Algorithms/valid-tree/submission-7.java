class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] nodes = new int[n];

        // Make each node point at "itself"
        for (int i = 1; i < n; i++) {
            nodes[i] = i;
        }

        for(int e[]: edges) {
            if (!connect(e[0], e[1], nodes)) return false;
        }

        // At this point, see if they all share the same base
        int base = findBase(0, nodes);

        for (int i = 1; i < n; i++) {
            if (base != findBase(i, nodes)) return false;
        }

        return true;
    }

    // Need to make two methods, one to find the lowest
    private int findBase(int x, int[] nodes) {
        // index are our source of truth, if it points to itself, return it
        if (nodes[x] == x) return x;

        // We are looking for the base, which means it selfpoints
        return findBase(nodes[x], nodes);
    }


    // One to connect them
    private boolean connect(int x, int y, int[] nodes) {
        // We are looking for two different "islands/sets"
        int xBase = findBase(x, nodes);
        int yBase = findBase(y, nodes);

        // This means they share the same base, already connected
        if (xBase == yBase) return false; 

        // Do the size thing after a working solution
        nodes[xBase] = yBase;

        return true;
    }
}








