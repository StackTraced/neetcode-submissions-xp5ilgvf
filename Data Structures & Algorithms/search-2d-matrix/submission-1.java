class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // We know that each row is already sorted
        int upperPointer = 0;
        int lowerPointer = matrix.length - 1;

        // We are looking for the row that contains our target
        while (upperPointer <= lowerPointer) {
            int outerMid = upperPointer + ((lowerPointer - upperPointer) / 2);

            if (matrix[outerMid][0] <= target && target <= matrix[outerMid][matrix[outerMid].length - 1]) {

                int lp = 0;
                int rp = matrix[outerMid].length - 1;

                while (lp <= rp) {
                    int innerMid = lp + ((rp - lp) / 2);

                    if (matrix[outerMid][innerMid] == target) {
                        return true;
                    }

                    // If it's too big -- Change <= to <, can't be <=
                    else if (target < matrix[outerMid][innerMid]) {
                        rp = innerMid - 1;
                    }

                    else {
                        lp = innerMid + 1;
                    }
                }

                
                // This implies we got out of the while loop, meaning we didn't find it
                return false;
            }

            // We already checked the end of the row, so we can safetly work with the first value of the row
            else if (matrix[outerMid][0] <= target) {
                upperPointer = outerMid + 1;
            }
            
            else {
                lowerPointer = outerMid - 1;
            }
        }

        // If we get here, we couldn't find it
        return false;
    }
}