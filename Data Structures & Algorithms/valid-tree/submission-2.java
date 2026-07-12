class Solution {
    
    private static class Node {
        int value;

        Node base;


        Node() {
            base = this;
        }

        Node(int value) {
            this.value = value;
            base = this;
        }
    }


    public boolean validTree(int n, int[][] edges) {
        Node[] map = new Node[n];

        for(int i = 0; i < n; i++) {
            map[i] = new Node(i);
        }

        for (int[] i: edges) {
            Node x = map[i[0]];
            Node y = map[i[1]];

            if (!union(x, y, map)) return false;
        }

        Node base = find(map[0]);

        for (int i = 1; i < n; i++) {
            Node currentIndexNode = find(map[i]);

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

    private boolean union(Node a, Node b, Node[] map) {
        Node aBaseNode = find(a);
        Node bBaseNode = find(b);

        if (aBaseNode == bBaseNode) return false;

        bBaseNode.base = aBaseNode;

        return true;
    }

    // private boolean union(int a, int b, int[] map) {
    //     //Node aBase = find(map[a], map);
    //     //Node bBase = find(map[b], map);

    //     //if (aBase == bBase) return false;

    //     //map[bBase] = aBase;

    //     return true;
    // }
}
