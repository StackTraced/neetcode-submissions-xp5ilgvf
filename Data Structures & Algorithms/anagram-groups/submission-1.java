class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Just getting a solution first
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            // First sort the s
            String sorted = sorter(s);

            // Here we can assume it does not exist
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }

    
            // Here we can assume it exist now, add that string to the sorted
            map.get(sorted).add(s);
        }


        // Sort each word and put in the index - Double list ...


        List<List<String>> solution = new ArrayList<>(map.values());
        
        return solution;
    }

    // private method to sort 
    private String sorter(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
