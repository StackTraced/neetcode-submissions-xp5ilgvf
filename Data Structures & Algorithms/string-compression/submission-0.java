class Solution {
    public int compress(char[] chars) {
        // If the array is of size 1
        if (chars.length == 1) {
            return 1;
        }

        int runner = 0;
        int anchor = 0;
        int index = 0;
        int count = 0;

        while(runner <= chars.length) {
            // It reached the end, handle it
            if (runner == chars.length) {
                index = writeAndGiveBackIndex(chars, anchor, String.valueOf(count), index);
                break; // or runner++
            }

            // It is equal, so move it over
            else if (chars[anchor] == chars[runner]) {
                count++;
                runner++;
            }

            else {
                index = writeAndGiveBackIndex(chars, anchor, String.valueOf(count), index);

                anchor = runner;
                count = 0;
            }
        }

        return index;
    }

    private int writeAndGiveBackIndex(char[] chars, int anchor, String count, int index) {
        // We write the current char in the place
        chars[index] = chars[anchor]; // Write into the space
        index++;

        if (count.equals("1")) {
            return index;
        }

        for(int i = 0; i < count.length(); i++) {
                chars[index] = count.charAt(i);
                index++;
        }

        return index;
    }


}