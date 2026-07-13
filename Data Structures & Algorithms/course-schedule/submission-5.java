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

        // Size check
        // for (var x: course.entrySet()) {
        //     System.out.printf("index %d is size %d\n", x.getKey(), x.getValue().size());
        // }

        for (int i = 0; i < numCourses; i++) {
            Set<Integer> seen = new HashSet<>();
            if(!dfs(i, course, seen)) return false; // Not sure if we should just pass a new set?
        }

        // after our logic, did we do anything
        // System.out.println("After");
        // for (var x: course.entrySet()) {
        //     System.out.printf("index %d is size %d\n", x.getKey(), x.getValue().size());
        // }

        // Created the course maps


        // Every course should be empty
        for(Set s: course.values()) {
            //System.out.println(s.size());
            if (!s.isEmpty()) return false;
        }

        return true;
    }

    // The goal is to empty out a set
    private boolean dfs(int c, Map<Integer, Set<Integer>> course, Set<Integer> seen) {
        //System.out.println("Before the false. Does it contain it?: " + seen.contains(c));
        
        if (seen.contains(c)) return false;


        //System.out.println("Course in DFS: " + c);

        Set<Integer> pre = course.get(c); // Writing it how I would in an assessment
        if (pre.isEmpty()) return true;
        
        for(int p: pre) {

            //System.out.println("We are passing: " + p);
            seen.add(c);
            
            if (!dfs(p, course, seen)) {
                //System.out.println("Is was false?");
                return false;
            }

            //System.out.println("Do we reach this?");

            seen.remove(c);
        }

        // If we get here, means it was possible, clear it
        course.put(c, new HashSet<>());


        return true;
    }
}
