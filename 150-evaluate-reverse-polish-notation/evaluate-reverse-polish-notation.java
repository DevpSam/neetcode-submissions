class Solution {
    public int Operate(int a, int b, String str){
        if(str.equals("+")){
            return a+b;
        }
        else if(str.equals("-")){
            return a-b;
        }
         else if(str.equals("*")){
            return a*b;
    } else if(str.equals("/")){
            return a/b;
    }
    return 0;
}
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
       for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int b = stack.pop(); 
                int a = stack.pop();

                int res = Operate(a, b, str);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        
        return stack.pop();
    }
}