class Solution {
    public int evalRPN(String[] tokens) {
        int output = 0;
        Stack<Integer> s = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int b = s.pop(), a = s.pop();
                    s.push(a + b);
                }
                case "-" -> {
                    int b = s.pop(), a = s.pop();
                    s.push(a - b);
                }
                case "*" -> {
                    int b = s.pop(), a = s.pop();
                    s.push(a * b);
                }
                case "/" -> {
                    int b = s.pop(), a = s.pop();
                    s.push(a / b);
                }
                default -> {
                    s.push(Integer.parseInt(token));
                }
            }

        }
        return s.pop();
    }
}