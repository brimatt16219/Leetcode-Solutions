class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<Character>();
        char[] letters = s.toCharArray();
        for (char c : letters)
        {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
    
    
    
    
}