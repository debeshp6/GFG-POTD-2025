class Solution {
    public void buildExpr(ArrayList<String> res, String expr, String digits, int target,
        int idx, int eval, int last) {
        if (idx == digits.length()) {
            if (eval == target) res.add(expr);
            return;
        }

        for (int i = idx; i < digits.length(); i++) {

            if (i != idx && digits.charAt(idx) == '0') break;
            String part = digits.substring(idx, i + 1);
            int num = Integer.parseInt(part);
            if (idx == 0) {
                buildExpr(res, part, digits, target, i + 1, num, num);
            } else {
                buildExpr(res, expr + "+" + part, digits, target, i + 1, eval + num, num);
                buildExpr(res, expr + "-" + part, digits, target, i + 1, eval - num,-num);
                buildExpr(res, expr + "*" + part, digits, target, i + 1, eval - last + last
                * num, last * num);
            }
        }
    }

    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> res = new ArrayList<>();
        buildExpr(res, "", s, target, 0, 0, 0);
        return res;
    }
}
