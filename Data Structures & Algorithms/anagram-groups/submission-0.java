class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Assert that the list is not empty
        if(strs.length == 0) {
            return new ArrayList<>();
        }
        
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> list = new HashMap<>();

        for(String s: strs) {
            // We want to build a key 
            char[] charList = s.toCharArray();
            Arrays.sort(charList);
            String key = new String(charList);
            //System.out.println(key);

            // If it doesn't exist, create a mapping
            if(!list.containsKey(key)) {
                list.put(key, new ArrayList());
            }

            // Insert into the list
            list.get(key).add(s);
            
        }
        
        for(String key: list.keySet()){
            //System.out.println(key);
            result.add(list.get(key));
        }




        return result;
    }
}
