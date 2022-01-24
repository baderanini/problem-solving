class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack();
        
        int strPointer = 0;
        stack.push("(");
        while(strPointer < s.length()) {
            StringBuilder currNumSb = new StringBuilder();
            while(strPointer < s.length() && Character.isDigit(s.charAt(strPointer))) {
                currNumSb.append(s.charAt(strPointer));
                strPointer++;
            }
            
            if(currNumSb.length() != 0) {
                tryPushNum(stack, currNumSb.toString());
                continue;
            } else if(s.charAt(strPointer) == ')') {
                tryPushNum(stack, handleBetweenparentheses(stack));
            } else {
                stack.push(String.valueOf(s.charAt(strPointer)));
            }
            strPointer++;
        }
        
        return Integer.parseInt(handleBetweenparentheses(stack));
    }
    
    String handleBetweenparentheses(Stack<String> stack) {
        int num = 0;
        while(stack.peek().charAt(0) != '(') {
            int sign = 1;
            String s = stack.pop();
            int currNum = Integer.parseInt(s);
            if(stack.peek().charAt(0) == '+' || stack.peek().charAt(0) == '-') {
                if(stack.pop().charAt(0) == '-')
                    sign = -1;
            }
            num += currNum*sign;
        }
        stack.pop();
        return String.valueOf(num);
    }
    
    void tryPushNum(Stack<String> stack, String num) {
        if(!stack.isEmpty() && isMulOrDiv(stack.peek()))
            stack.push(calc(num, stack.pop(), stack.pop()));
        else
            stack.push(num);
    }
    
    String calc(String num1, String op, String num2) {
        int n1 = Integer.parseInt(num1), n2 = Integer.parseInt(num2);
        switch (op) {
            case "+": return String.valueOf(n2+n1);
            case "-": return String.valueOf(n2 - n1);
            case "*": return String.valueOf(n2 * n1);
            case "/": return String.valueOf(n2 / n1);
            default: return String.valueOf(0);
        }
    }
    
    boolean isMulOrDiv(String s) {
        return s.charAt(0) == '*' || s.charAt(0) == '/';
    }
}