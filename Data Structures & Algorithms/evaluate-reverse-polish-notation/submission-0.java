class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int n = tokens.length;
        int result = 0;
        for (int i = 0; i<n;i++){
            if (tokens[i].equals("+")){
                int b = st.pop();
                int a = st.pop();
                result = a+b;
                st.push(result);
            }
            else if (tokens[i].equals("-")){
                int b = st.pop();
                int a = st.pop();
                result = a-b;
                st.push(result);
            }
            else if (tokens[i].equals("*")){
                int b = st.pop();
                int a = st.pop();
                result = a*b;
                st.push(result);
            }
            else if (tokens[i].equals("/")){
                int b = st.pop();
                int a = st.pop();
                result = a/b;
                st.push(result);
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}
