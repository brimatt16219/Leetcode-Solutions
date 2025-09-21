class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        String[] parts = path.split("/");

        for (String p : parts) {
            if (p.isEmpty() || p.equals(".")) {
                continue;
            }
            else if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pollLast();
            }
            else {
                stack.addLast(p);
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append('/').append(dir);
        }
        return sb.toString();
    }
}