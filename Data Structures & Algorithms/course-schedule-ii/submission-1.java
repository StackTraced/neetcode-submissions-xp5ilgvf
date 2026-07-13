class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();


        // Build the map
        Map<Integer, Set<Integer>> map = new HashMap<>();

        boolean[] completed = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }

        for (int[] i: prerequisites) {
            map.get(i[0]).add(i[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, result, new HashSet<>(), completed)) return new int[0];
        }

        // Sets are not ordered....
        // Would we need a seen again, two sets?
        System.out.println("Checking");
        for(int i: result) {
            System.out.println(i);
        }
        // This solves the array empty problem and not matching size for now...
        return (result.isEmpty() || result.size() != numCourses) ? new int[0] : convert(result, numCourses);
    }


    private boolean dfs(int c, Map<Integer, Set<Integer>> course, List<Integer> result,
    Set<Integer> seen, boolean[] completed) {

        // On top
        if (completed[c]) return true; // Its false by default, can only be true if valid

        if (seen.contains(c)) return false; // A cycle? 

        Set<Integer> pre = course.get(c);
        // Base case to add a course thats empty

        if (pre.isEmpty()) {
            System.out.println("Test for : " + c);
            // Did we already complete this? If we complete it already, does it matter?
            // If its complete, means its empty

            // Inside the isEmpty - we can assume its false
            completed[c] = true;

            result.add(c); // This may override in the future? add a set to fix that
            return true;
        }

        

        seen.add(c);

        for(int i: pre) {
            if (!dfs(i, course, result, seen, completed)) return false;
        }

        seen.remove(c);


        course.put(c, new HashSet<>());
        result.add(c);
        completed[c] = true;

        return true;
    }




    private int[] convert(List<Integer> result, int courses) {
        int[] arr = new int[courses];

        for(int i = 0; i < courses; i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }
}
