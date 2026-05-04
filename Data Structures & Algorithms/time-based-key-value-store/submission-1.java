class TimeMap {

    private HashMap<String, List<Node>> map;

    private class Node {
        String value;
        int timestamp;

        Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String result = "";

        // Grab its list
        List<Node> list = map.get(key);

        if (list == null || list.size() == 0) return result;
        

        // Brute Force
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).timestamp <= timestamp) {
                return list.get(i).value;
            }
        }

        return "";
    }
}
