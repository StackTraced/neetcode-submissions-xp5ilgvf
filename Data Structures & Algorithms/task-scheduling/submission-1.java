class Solution {

    // An object to store - by default always has 0
    // I cant figure out the data structure, so will make my own
    private static class Node {
        
        char character;
        int minimumCycle;
        int count;

        Node(char character, int count) {
            this.character = character;
            this.count = count;
            minimumCycle = 0;
        }

        Node(int count) {
            this.count = count;
            minimumCycle = 0;
        }
 
        void updateCycle(int currentCycle, int n) {
            this.minimumCycle = currentCycle + n + 1;
        }

        boolean canUse(int currentCycle) {
            return currentCycle >= minimumCycle;
        }

        void decrementCount() {
            count = count - 1;
        }

        boolean isValid() {
            return count > 0;
        }
    }

    // Im sure there is a better way of doing this, but want to solve it once myself
    public int leastInterval(char[] tasks, int n) {

        int[] alpha = new int[26];

        // We want the highest count?
        //PrioriyQueue<Node> storingAvailable = new Priortiy<>((a, b) -> node)
        HashMap<Character, Integer> count = new HashMap<>();

        // Lets us grab the "letter" with the most count
        PriorityQueue<Node> highestCount = new PriorityQueue<>((a, b) -> b.count - a.count);
        
        // Guarantee to have the lowest minimum cycle at peek(), if we peek and see the lowest can be used, throw it 
        // in the maxHeap
        PriorityQueue<Node> lowestCooldown = new PriorityQueue<>((a, b) -> a.minimumCycle - b.minimumCycle);

        for(char c:tasks) {
            alpha[c - 'A']++;
        }

        for(int i = 0; i < 26; i++) {

            if (alpha[i] > 0) {
                highestCount.add(new Node(alpha[i]));
            }
        }

        // Now the highestCount has all the "character"
        int currentCycle = 0;

        while(highestCount.size() > 0 || lowestCooldown.size() > 0) {
            // Peek at cooldown, see if we can add it back
            while(!lowestCooldown.isEmpty() && lowestCooldown.peek().canUse(currentCycle)) {
                // Puts it back into it
                highestCount.add(lowestCooldown.poll());
            }

            // We want to grab the one with the highest count, everything in this heap is in play
            // Can be empty sometimes
            if (!highestCount.isEmpty()) {
                Node j = highestCount.poll();
                j.decrementCount();
                if (j.isValid()) {
                    j.updateCycle(currentCycle, n);
                    lowestCooldown.add(j);
                }
            }

            currentCycle++;
        }

        return currentCycle;
    }
}
