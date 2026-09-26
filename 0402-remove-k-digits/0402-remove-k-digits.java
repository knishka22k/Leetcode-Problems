class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i<num.length(); i++){
            while (!s.empty() && k>0 && (s.peek()-'0') > (num.charAt(i)-'0')){
                s.pop();
                k--;
            }
            s.push(num.charAt(i));
        }

        while (k>0) {
            s.pop();
            k--;
        }

        if (s.empty())
            return "0";

        StringBuilder ans = new StringBuilder("");
        while (!s.empty()){
            ans = ans.append(s.pop());
        }

        String str = ans.reverse().toString();
        int j =0;
        for (; j<str.length(); j++){
            if (str.charAt(j) != '0')
                break;
        }
        str = str.substring(j);
        if (str.length()==0)
            return "0";
        return str;
    }
}