class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        double[] timeToTarget = new double[position.length];



        int numberOfFleets = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }

        // Now sort it
        Arrays.sort(position);

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < position.length; i++) {
            stack.add(
                (double)(target - position[i]) / (double) map.get(position[i])
            );
        }

        while (!stack.isEmpty()) {
            numberOfFleets++;

            // Guarantee to have a value inside
            double currSpeed = stack.pop();

            // If the car behind it is the same speed or would take less time than currSpeed, bottle neck it to the current car
            while (!stack.isEmpty() && stack.peek() <= currSpeed) stack.pop();
        }

        return numberOfFleets;
    }
}
