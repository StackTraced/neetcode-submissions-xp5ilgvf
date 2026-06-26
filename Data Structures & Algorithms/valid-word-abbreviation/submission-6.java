class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordPointer = 0;
        int abbrPointer = 0;

        while (abbrPointer < abbr.length() && wordPointer < word.length()) {
            char c = abbr.charAt(abbrPointer);
            
            if (Character.isLetter(c)) {
                System.out.println("checking to compare c: " + word.charAt(wordPointer));
                if (c != word.charAt(wordPointer)) {
                    return false;
                }

                abbrPointer++;
                wordPointer++;
            }

            // We have a digit
            else {
                if (c == '0') return false; // We have a leading zero
                // We want to get the number itself
                int number = abbr.charAt(abbrPointer) - '0';
                abbrPointer++;

                while (abbrPointer < abbr.length() && Character.isDigit(abbr.charAt(abbrPointer))) {
                    int tmp = abbr.charAt(abbrPointer) - '0';
                    number *= 10;
                    number += tmp;
                    abbrPointer++;
                }

                wordPointer += number;
            }
        
        }

        // If they are at the end, both of them made it to their exact pos
        return wordPointer == word.length() && abbrPointer == abbr.length();
    }
}