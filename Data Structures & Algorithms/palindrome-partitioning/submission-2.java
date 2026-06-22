class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        search(result, current, 0, s);
        return result;
    }


    private void search(List<List<String>> result, List<String> current, int j, String s) {
        
        

        if (j >= s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }


        for (int i = j; i < s.length(); i++) {
            
            //System.out.printf("i: %d\tj:%d\n", i, j + 1);
            
            if (isPalindrome(j, i, s)) {
                current.add(s.substring(j, i + 1));
                search(result, current, i + 1, s);
                current.remove(current.size() - 1);
            }
        }
    }

    // We don't need to make a substring, we can use pointers for O(1) memory
    private boolean isPalindrome(int lp, int rp, String s) {

        while (lp < rp) {
            if (s.charAt(lp) != s.charAt(rp)) return false;

            lp++;
            rp--;
        }

        return true;

    }
}
