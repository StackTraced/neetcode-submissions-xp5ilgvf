class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
         
        for(int i = 0; i < flowerbed.length; i++) {
            boolean leftClear = (i - 1) < 0 || flowerbed[i -1] == 0;
            boolean rightClear = (i + 1) >= flowerbed.length || flowerbed[i + 1] == 0;
            
            if (leftClear && rightClear && (flowerbed[i] == 0)) {
                n--;
                i++;
            }
        }


        return n <= 0;
    }
}