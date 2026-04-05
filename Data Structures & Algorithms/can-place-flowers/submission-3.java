class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
         
        // Guarantee to be length of 1

        int index = 0;

        while (index < flowerbed.length) {


            boolean leftClear = (index - 1) < 0 || flowerbed[index -1] == 0;
            boolean rightClear = (index + 1) >= flowerbed.length || flowerbed[index + 1] == 0;
            
            if (leftClear && rightClear && (flowerbed[index] == 0)) {
                n--;
                // move the index
                index += 2;
            }
            else {
                index++;
            }
        }


        return n <= 0;
    }
}