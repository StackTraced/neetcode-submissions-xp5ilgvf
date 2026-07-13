class Solution {
    public int countComponents(int n, int[][] edges) {
        int numberOfIslands = n;
        int[] size = new int[n]; // For later

        int[] islands = new int[n];

        for(int i = 0; i < n; i++) {
            islands[i] = i;
            size[i] = 1;
        }

        for(int[] e: edges) {
            if (merged(e[0], e[1], islands, size)) numberOfIslands--;
        }


        return numberOfIslands;
    }

    // Whenever we connect, we remove an "island"
    private boolean merged(int x, int y, int[] islands, int[] size) {
        // If they share the same base, we won't be merging
        int xBase = findBase(x, islands);
        int yBase = findBase(y, islands);

        if (xBase == yBase) return false; // We did not add a new connection


        int sizeOfX = size[xBase];
        int sizeOfY = size[yBase];
        // Using xBase, we want the number of nodes connected to that node, not the index itself

        // if sizeOfX is 3 and sizeOfY is 100, we want to adjust all 2 nodes connected to baseX to now point at baseY
        // If we do it the other way, now 100 nodes will get an extra space....
        if (sizeOfX < sizeOfY) {
            islands[xBase] = yBase;
            // Node xBase = new Node() --> xBase.base = yBase;
            // The y base grew, in cluster
            size[yBase] += size[xBase];
        }
        else {
            islands[yBase] = xBase;
            // The x base grew, in cluster
            size[xBase] += size[yBase];
        }

        // We have two different islands that are connecting, removing one
        // Deal with size later
        //islands[yBase] = xBase;


        return true;
    }

    private int findBase(int x, int[] islands) {
        if (islands[x] == x) return x;

        return findBase(islands[x], islands);
    }



}
