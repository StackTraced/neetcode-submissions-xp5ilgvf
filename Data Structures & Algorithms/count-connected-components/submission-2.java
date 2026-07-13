class Solution {
    public int countComponents(int n, int[][] edges) {
        int numberOfIslands = n;
        int[] size = new int[n]; 

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

    private boolean merged(int x, int y, int[] islands, int[] size) {
        int xBase = findBase(x, islands);
        int yBase = findBase(y, islands);

        if (xBase == yBase) return false; 


        int sizeOfX = size[xBase];
        int sizeOfY = size[yBase];
        // Using xBase, we want the number of nodes connected to that node, not the index itself

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
        if (islands[x] == x) {
            return x;
        }

        int pointer = findBase(islands[x], islands);
        islands[x] = pointer;
        return pointer;
    }



}
