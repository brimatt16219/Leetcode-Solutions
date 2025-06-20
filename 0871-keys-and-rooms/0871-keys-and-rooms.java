class Solution {

    static boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];

        visitRoom(rooms, 0);

        for (boolean boo : visited) {
            if (!boo) return false;
        }
        return true;
    }

    void visitRoom(List<List<Integer>> rooms, int room) {

        if (visited[room]) return;
        visited[room] = true;

        for (int key : rooms.get(room)) {
            visitRoom(rooms, key);
        }
        
    }
}