class Solution {
    public int[][] merge(int[][] intervals) {
        // Using [0], to sort by starting inverbals
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> result = new ArrayList<>();
        // result.add(new int[]{start, end});
        // return result.toArray(new int[0][]);

        // Guaranteed to always have 1
        int floor = intervals[0][0];
        int ceiling = intervals[0][1];

        // if there is just one, return it
        //if (intervals.length == 1) {
        //    return result.toArray(new int[0][]); // Something something Java to return int
        //}
        // Then again, would skip the loop...if the size is 1


        for (int i = 1; i < intervals.length; i++) {
            int newFloor = intervals[i][0];
            int newCeiling = intervals[i][1];

            // Check to see if the floor is below the current ceiling
            // Can't be smaller, due to sorting
            if (newFloor <= ceiling) {
                // Scope it so we can determine a new ceiling
                System.out.println("MOVING");
                System.out.println("Old Ceiling: " + ceiling);
                ceiling = Math.max(newCeiling, ceiling);
                System.out.println("New Ceiling: " + ceiling);
            }

            // We can assume we got a ceiling that's bigger, so new interval
            // May skip one though....need to think of that later..optimzie later
            else {
                System.out.println("Ceiling Insert: " + ceiling);
                result.add(new int[]{floor, ceiling}); // Add the old here
                floor = newFloor;
                ceiling = newCeiling;
                // loop back?
            }


            // Just add it?
        }

        result.add(new int[]{floor, ceiling});

        return result.toArray(new int[0][]);


    }
}
