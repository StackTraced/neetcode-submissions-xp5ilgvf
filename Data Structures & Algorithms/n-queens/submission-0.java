class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        
        int[] selectedCols = new int[n];

        Set<Integer> validCols = new HashSet<>();
        for (int a = 0; a < n; a++) {
            validCols.add(a);
        }

        Set<Integer> selectedTopLeftDiag = new HashSet<>();
        Set<Integer> selectedTopRightDiag = new HashSet<>();
    
        findQueens(0, validCols, n, result, selectedCols, selectedTopLeftDiag, selectedTopRightDiag);


        return result;
    }


    private void findQueens(int currentRow, Set<Integer> validCols, int n, List<List<String>> result, int[] selectedCols, Set<Integer> selectedTopLeftDiag, Set<Integer> selectedTopRightDiag) {
        //System.out.println("currentRow" + currentRow);
        // We are passing currentRow + 1 per loop,

        // We have a legal board

        if (currentRow >= n) {
            // Compute said board, so we have it somewhere
            // selectedCols is the size of n....
            computeResponse(result, selectedCols, n);
            return;
        }

        // We want to pick a col that works
        for (int c = 0; c < n; c++) {
            // We have a list of valid cols, can we use it?
            // we can't use that col, next one
            if (!validCols.contains(c)) continue;

            // Check to see if diags are legal

            // Is there a selected col in the list of banned 

            if (selectedTopLeftDiag.contains(currentRow + c)) continue;
            if (selectedTopRightDiag.contains(currentRow - c)) continue;
            //if (diagBan.contains(currentRow + c) || diagBan.contains(currentRow - c)) continue;
            // We need to check, is there a



            validCols.remove(c);
            selectedTopLeftDiag.add(currentRow + c);
            selectedTopRightDiag.add(currentRow - c);
            //Set<Integer> selectedTopLeftDiag = new HashSet<>();
            //Set<Integer> selectedTopRightDiag = new HashSet<>();
            //selectedTopLeftDiag.add(c - 1);
            //selectedTopRightDiag.add(c + 1);

            selectedCols[currentRow] = c;



            // We have a valid col so we
            findQueens(currentRow + 1, validCols, n, result, selectedCols, selectedTopLeftDiag, selectedTopRightDiag);

            validCols.add(c);

            selectedTopLeftDiag.remove(currentRow + c);
            selectedTopRightDiag.remove(currentRow - c);
        }

        // If we get here, none of the cols were valid
        // May need to prune later
    }


    private void computeResponse(List<List<String>> result, int[] selectedCols, int n) {
        
        List<String> localAnswer = new ArrayList<>();

        for(int i = 0; i < selectedCols.length; i++) {
            // Build a char Array?
            char[] c = new char[n];

            // Ill figure the way out, brain fart

            for (int b = 0; b < n; b++) {
                c[b] = '.';
            }

            c[selectedCols[i]] = 'Q';

            localAnswer.add(String.valueOf(c));
        }

        

        result.add(localAnswer);
    }
}
