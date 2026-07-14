class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> course = new HashMap<>();   

        // Build the list
        for (int i = 0; i < numCourses; i++) {
            course.put(i, new HashSet<>());
        }

        // Build the map
        for(int[] e: prerequisites) {
            // Guarantee to have a set now in there
            course.get(e[0]).add(e[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            Set<Integer> seen = new HashSet<>();
            if(!dfs(i, course, seen)) return false; // Not sure if we should just pass a new set?
        }

        return true;
    }

    // The goal is to empty out a set
    private boolean dfs(int c, Map<Integer, Set<Integer>> course, Set<Integer> seen) {
        //System.out.println("Before the false. Does it contain it?: " + seen.contains(c));
        
        if (seen.contains(c)) return false;

        Set<Integer> pre = course.get(c); // Writing it how I would in an assessment
        if (pre.isEmpty()) return true;
        
        seen.add(c);

        for(int p: pre) {
            if (!dfs(p, course, seen)) {
                //System.out.println("Is was false?");
                return false;
            }
        }

        seen.remove(c);

        course.put(c, new HashSet<>());


        return true;
    }
}
