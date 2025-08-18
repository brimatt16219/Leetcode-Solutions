/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return build(grid, 0, 0, n);
    }

    private Node build(int[][] grid, int r, int c, int size) {
        int first = grid[r][c];
        boolean allSame = true;
        for (int i = 0; i < size && allSame; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[r + i][c + j] != first) {
                    allSame = false;
                    break;
                }
            }
        }
        if (allSame) {
            return new Node(first == 1, true);
        }

        int half = size / 2;
        Node tl = build(grid, r, c, half);
        Node tr = build(grid, r, c + half, half);
        Node bl = build(grid, r + half, c, half);
        Node br = build(grid, r + half, c + half, half);

        return new Node(false, false, tl, tr, bl, br);
    }
}