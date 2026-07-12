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

        Node base = find(nodes[0]);

        for (int i = 1; i < n; i++) {
            Node currentIndexNode = find(nodes[i]);

            if (currentIndexNode != base) {
                return false;
            }
        }

        return true;
    }


    private Node find(Node n) {
        if (n == n.base) {
            return n;
        }

        Node result = find(n.base);
        n.base = result;

        return result;
    }

    private boolean union(Node a, Node b) {
        Node aBaseNode = find(a);
        Node bBaseNode = find(b);

        if (aBaseNode == bBaseNode) return false;

        // When we first do this, both have 1 node each
        if (aBaseNode.size < bBaseNode.size) {
            aBaseNode.base = bBaseNode;
            aBaseNode.size += bBaseNode.size;
        }
        else {
            bBaseNode.base = aBaseNode;
            bBaseNode.size += aBaseNode.size;
        }

        return true;
    }
}
