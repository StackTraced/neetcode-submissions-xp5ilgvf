class Solution {
    public int countComponents(int n, int[][] edges) {
        int numberOfIslands = n;
        int[] size = new int[n]; // For later

        int[] islands = new int[n];

        for(int i = 0; i < n; i++) {
            islands[i] = i;
        }

        for(int[] e: edges) {
            if (newConnection(e[0], e[1], islands)) numberOfIslands--;
        }


        return numberOfIslands;
    }

    // Whenever we connect, we remove an "island"
    private boolean newConnection(int x, int y, int[] islands) {
        // If they share the same base, we won't be merging
        int xBase = findBase(x, islands);
        int yBase = findBase(y, islands);

        if (xBase == yBase) return false; // We did not add a new connection

        // We have two different islands that are connecting, removing one
        // Deal with size later
        islands[yBase] = xBase;


        return true;
    }

    private int findBase(int x, int[] islands) {
        if (islands[x] == x) return x;

        return findBase(islands[x], islands);
    }



}
