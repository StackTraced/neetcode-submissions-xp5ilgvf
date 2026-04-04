class MinStack {

    private LinkedList<Integer> list;
    private LinkedList<Integer> minList;

    
    public MinStack() {
        list = new LinkedList<>();    
        minList = new LinkedList<>();
    }
    
    public void push(int val) {
        list.addFirst(val);

        if (minList.isEmpty() || (val <= minList.peekFirst())) {
            minList.push(val);
        }
    }
    
    public void pop() {
        int value = list.removeFirst();

        if (!minList.isEmpty() && value == minList.peekFirst()) {
            minList.removeFirst();
        }
    }
    
    public int top() {
        return list.peekFirst();
    }
    
    public int getMin() {
        return minList.isEmpty() ? 0 : minList.peekFirst();
    }
}
