class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        boolean[] canAttend = new boolean[numCourses];

        // We know its labeled 0 to numCourse - 1

        // Iterate over and create the nodes
        for(int[] i: prerequisites) {
            // i[0] is the course name
            // i[1] is the prerequisite

            map.get(i[0]).add(i[1]);
        }

        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            dfs(seen, map, i, canAttend);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(seen, map, i, canAttend)) return false;
        }

        return true;
        
    }


    private boolean dfs(HashSet<Integer> seen, HashMap<Integer, List<Integer>> map, int course, boolean[] canAttend) {
        if (seen.contains(course)) return false;

        if (map.get(course).isEmpty()) {
            canAttend[course] = true;
            return true;
        }

        
        seen.add(course);

        // We have some prerequsites now
        for(int i: map.get(course)) {
            if (!dfs(seen, map, i, canAttend)) return false;
        }

        seen.remove(course);
        canAttend[course] = true;

        return true;
    }
}
