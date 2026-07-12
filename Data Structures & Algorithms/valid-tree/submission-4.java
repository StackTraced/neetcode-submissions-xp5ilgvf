class Solution {
    
    private static class Node {
        int value;
        int size;
        Node base;

        Node(int value) {
            this.value = value;
            base = this;
            size = 1; // Default is always 1, itself
        }
    }


    public boolean validTree(int n, int[][] edges) {
        Node[] nodes = new Node[n];

        for(int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        for (int[] i: edges) {
            Node x = nodes[i[0]];
            Node y = nodes[i[1]];

            if (!union(x, y)) return false;
        }

        Node base = find(nodes[0], 0);

        for (int i = 1; i < n; i++) {
            Node currentIndexNode = find(nodes[i], 0);

            if (currentIndexNode != base) {
                return false;
            }
        }

        return true;
    }


    private Node find(Node n, int depth) {
        if (n == n.base) {
            return n;
        }
        depth++;

        n.size = depth;

        Node result = find(n.base, depth);
        n.base = result;

        return result;
    }

    private boolean union(Node a, Node b) {
        Node aBaseNode = find(a, 0);
        Node bBaseNode = find(b, 0);

        if (aBaseNode == bBaseNode) return false;

        // Make the smaller one point to the bigger one
        // We have depth for each one, we guarantee to + 1 it, make the smaller one move

        if (aBaseNode.size < bBaseNode.size) {
            aBaseNode.base = bBaseNode;
        }
        else {
            bBaseNode.base = aBaseNode;
        }

        return true;
    }
}
