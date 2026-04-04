class Solution {

    private static final String SPLITTER = "#";
    private static final Character CHAR_SPLITTER = '#';

    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return "";
        }
        
        StringBuilder encodedString = new StringBuilder();

        for (String s : strs) {
            encodedString.append(s.length()).append(SPLITTER).append(s);
        }
        
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }

        System.out.println(str);
        List<String> decodedList = new ArrayList<>();

        int leftPointer = 0;
        int rightPointer = 0;

        while (leftPointer < str.length()) {
            // Look for the splitter
            while (rightPointer < str.length() && str.charAt(rightPointer) != CHAR_SPLITTER) {
                rightPointer++;
            }

            // We found the splitter, grab the size
            String stringNumber = str.substring(leftPointer, rightPointer);
            int stringToNumber = Integer.parseInt(stringNumber);
            rightPointer++; // Move past the splitter
            leftPointer = rightPointer + stringToNumber;
            
            // Add the substring to the decoded list
            decodedList.add(str.substring(rightPointer, leftPointer));
            
            // Update rightPointer for the next iteration
            rightPointer = leftPointer;
        }

        return decodedList;
    }
}
