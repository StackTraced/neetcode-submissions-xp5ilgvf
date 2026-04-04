class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Just getting a solution first
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            String sorted = sorter(s);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(s);
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
