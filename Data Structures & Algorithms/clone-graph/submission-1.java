/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// Steps
// Have we 
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        deepCopy(node, map);

        return map.get(node);
    }

    private void deepCopy(Node node, HashMap<Node, Node> map) {
        // If we have seen this before, we return
        if (map.containsKey(node)) {
            return;
        }

        // This is a brand new node we're in, create it
        map.put(node, clonedNodeValues(node));

        // Now that we are in here, we want to iterate it's neighbors
        for(Node n: node.neighbors) {
            deepCopy(n, map);

            // Grab the cloned copy
            Node cloned = map.get(node);
            Node neighborClone = map.get(n);
            
            cloned.neighbors.add(neighborClone);
        }
    }

    
    private Node clonedNodeValues(Node node) {
        return new Node(node.val, new ArrayList<>());
    }
}