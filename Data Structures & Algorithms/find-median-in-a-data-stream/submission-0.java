class MedianFinder {

    // Brute Force - Simple Version

    private int sum = 0;
    private ArrayList<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }
    
    public double findMedian() {
        
        int size = list.size();

        if (size == 1) {
            return list.get(0);
        }

        int split = size / 2;
        // 2 -> 1
        // 3 -> 1
        // 4 -> 2
        // 5 -> 2
        // 6 -> 3

        // Even amount
        if (size % 2 == 0) {
            int a = list.get(split);
            int b = list.get(split - 1);

            return (double) (a + b) / 2.0;
        }

        return list.get(split);
    }
}
