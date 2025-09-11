class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<Character>();

        for(char digit: num.toCharArray()){
            while(!s.isEmpty() && k>0 && s.peek() > digit){
                s.pop();
                k--;
            }
            s.push(digit);
        }
        while(k>0 && !s.isEmpty()){
            s.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!s.isEmpty()){
            sb.append(s.pop());
        }

        sb.reverse();

        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.length() > 0 ? sb.toString() : "0";

    }
}

