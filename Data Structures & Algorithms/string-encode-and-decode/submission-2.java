class Solution {

    public String encode(List<String> strs) {
        // We can easily append
        StringBuilder sb = new StringBuilder();

        // We have a list of string, which we want to traverse each

        for(String s: strs) {
            int size = s.length();

            String word = String.valueOf(size);

            sb.append(word + "#" + s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedList = new ArrayList<>();
        
        // Using substring to grab the value? 
        for (int i = 0; i < str.length(); i++) {
            int index = i;

            while(str.charAt(index) != '#') {
                index++;
            }

            int sizeOfWord = Integer.parseInt(str.substring(i, index));

            // Then we go from index 
            String orginalWord = str.substring(index + 1, index + sizeOfWord + 1);

            decodedList.add(orginalWord);
            // adjust i
            i = index + sizeOfWord;
        }
        
        return decodedList;
    }
}
