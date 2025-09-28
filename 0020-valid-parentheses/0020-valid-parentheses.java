class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '{'  || c == '[' || c == '('){
                st.push(c);
                continue;
            }
            if (st.isEmpty())
                return false;
            
            char check;
            switch (c) {
            case ')':
                check = st.pop();
                if (check == '{' || check == '[')
                    return false;
                break;

            case '}':
                check = st.pop();
                if (check == '(' || check == '[')
                    return false;
                break;

            case ']':
                check = st.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
            
        }
        return st.isEmpty();
    }
}