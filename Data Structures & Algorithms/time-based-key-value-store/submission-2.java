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
        
        int lp = 0;
        int rp = list.size() - 1;

        String candidate = "";

        while (lp <= rp) {
            int mid = lp + ((rp - lp) / 2);

            if (list.get(mid).timestamp == timestamp) {
                return list.get(mid).value;
            }
            
            if (list.get(mid).timestamp > timestamp) {
                rp = mid - 1;
            }

            else {
                candidate = list.get(mid).value;

                lp = mid + 1;
            }
        }
        
        return candidate;
    }
}
