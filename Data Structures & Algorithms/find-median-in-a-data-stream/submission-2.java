class MedianFinder {

    // This will pop its smallest value
    private PriorityQueue<Integer> heapA;

    // This will pop its highest value
    private PriorityQueue<Integer> heapB;

    public MedianFinder() {
        this.heapA = new PriorityQueue<>(Comparator.reverseOrder()); 
        this.heapB = new PriorityQueue<>(Comparator.naturalOrder()); 
    }
    
    public void addNum(int num) {
        if (heapA.size() == 0 && heapB.size() == 0) {
            heapA.add(num); // Just put it in heapA for now
        }

        // If the current number smaller than heapA biggest number?
        else if (num < heapA.peek()) {
            heapA.add(num);
        }
        else {
            heapB.add(num);
        }
        // If it is bigger, put it in heapB
        // Else put it in heapA
        balancer();
    }

    private void balancer() {
        int sizeA = heapA.size();
        int sizeB = heapB.size();

        // It's too big on one side
        if (Math.abs(sizeA - sizeB) >= 2) {
            if (sizeA > sizeB) {
                // We pop heapA highest value and put it into heapB
                heapB.add(heapA.poll());
            }
            else {
                heapA.add(heapB.poll());
            }
        }
    }
    
    public double findMedian() {
        // if one is bigger, return that one
        if (heapA.size() != heapB.size()) {   
            if (heapA.size() > heapB.size()) return heapA.peek();
            return heapB.peek();
        }

        int valueA = heapA.peek();
        int valueB = heapB.peek();

        double result = valueA + valueB;
        result /= 2;
        return result;
    }
}
