class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpen = new HashMap<>();

        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');
        for (char c : s.toCharArray()) { 
            if (closeToOpen.containsKey(c)) { // closing bracket
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    stack.pop();
                }
                else return false;
            }
            else { // opening bracket
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}