class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder newS = new StringBuilder();
        int depth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth++ > 0) {
                    newS.append(c);
                }
            } else {
                if (--depth > 0) {
                    newS.append(c);
                }
            }
        }

        return newS.toString();

    }
}