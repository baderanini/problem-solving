// TODO: rewrite a cleaner code.

class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack();
        
        int i = 0;
        StringBuilder b = new StringBuilder();
        boolean isNum = false;
        while(i < s.length()) {
            char curr = s.charAt(i);
            if(Character.isAlphabetic(curr)) {
                isNum = false;
                b.append(curr);
            } else if(Character.isDigit(curr)) {
                if(isNum)
                    b.append(curr);
                else {
                    isNum = true;
                    if(b.length() != 0) pushString(b.toString(), stack);
                    b = new StringBuilder();
                    b.append(curr);
                }
            } else {
                isNum = false;
                if(b.length() != 0) {
                    pushString(b.toString(), stack);
                    b = new StringBuilder();
                }
                if(curr == ']') {
                   String str = stack.pop();
                    String num = stack.pop();
                    String decoded = decode(str, num);
                    pushString(decoded, stack);
                }
            }
            i++;
        }
        if(b.length() != 0)
            stack.push(b.toString());
        
        Stack<String> sec = new Stack();
        
        while(!stack.isEmpty())
            sec.push(stack.pop());
        
        StringBuilder res = new StringBuilder();
        
        while(!sec.isEmpty())
            res.append(sec.pop());
        
        return res.toString();
    }
    
    void pushString(String s, Stack<String> stack) {
        if(!stack.isEmpty() && Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(stack.peek().charAt(0)))
            stack.push(stack.pop()+s);
        else
            stack.push(s);
    }
    
    String decode(String s, String numStr) {
        int num = Integer.parseInt(numStr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < num ; i++)
            sb.append(s);
        
        return sb.toString();
    }
}
