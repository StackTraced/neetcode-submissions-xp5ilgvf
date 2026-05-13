class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        
        compute(sb, result, 0, 0, n);

        return result;
    }


    private void compute(StringBuilder sb, List<String> result, int openCount, int closingCount, int n) {
        if ((openCount == n) && (closingCount == n)) {
            result.add(sb.toString());
            return;
        }

        if (openCount + 1 <= n) {
            sb.append("(");
            compute(sb, result, openCount + 1, closingCount, n);
            sb.setLength(sb.length() - 1);
        }

        if (closingCount + 1 <= openCount) {
            sb.append(")");
            compute(sb, result, openCount, closingCount + 1, n);
            sb.setLength(sb.length() - 1);    
        }
    }
}
