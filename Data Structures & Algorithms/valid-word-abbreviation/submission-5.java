class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word.equals(abbr)) return true;

        int abbrPointer = 0;
        int wordPointer = 0;

        while (abbrPointer < abbr.length()) {
            // Check if they both match
            char c = abbr.charAt(abbrPointer);

            // If its a char,
            if (Character.isLetter(c)) {
                // Check if they are equal
                // Check to see if allowed
                if (wordPointer >= word.length()) return false;

                if (abbr.charAt(abbrPointer) != word.charAt(wordPointer)) return false;

                abbrPointer++;
                wordPointer++;

                continue;
            }

            // We likely have a digit now
            int runner = abbrPointer;

            while(runner < abbr.length() && Character.isDigit(abbr.charAt(runner))) runner++;

            String potentialNumber = abbr.substring(abbrPointer, runner);
            if (potentialNumber.startsWith("0")) return false;
            int value = Integer.parseInt(potentialNumber);
            // Now we loop it as above, maybe should make it a method....
            // Check if OOB first

            // We move the pointer this many times
            wordPointer += value;

            if (value > word.length()) return false;

            abbrPointer = runner;
        }


        return (abbrPointer >= abbr.length() && wordPointer == word.length());
    }
}