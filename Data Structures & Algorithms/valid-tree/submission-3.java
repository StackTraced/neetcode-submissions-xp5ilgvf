class Solution {
    
    private static class Node {
        int value;

        Node base;

        Node(int value) {
            this.value = value;
            base = this;
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
        if (n == n.base) return n;

        return find(n.base);
    }

    private boolean union(Node a, Node b) {
        Node aBaseNode = find(a);
        Node bBaseNode = find(b);

        if (aBaseNode == bBaseNode) return false;

        bBaseNode.base = aBaseNode;

        return true;
    }
}
