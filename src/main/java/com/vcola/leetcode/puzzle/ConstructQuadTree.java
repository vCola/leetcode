package com.vcola.leetcode.puzzle;

/**
 * 427. 建立四叉树
 *
 * @author Very Cola
 * @date 2018年11月9日 上午10:11:46
 */
public class ConstructQuadTree {

  public Node construct(int[][] grid) {
    return construct(grid, 0, grid.length - 1, 0, grid.length - 1);
  }

  private Node construct(int[][] grid, int startRow, int endRow, int startCol, int endCol) {
    if (isSameVal(grid, startRow, endRow, startCol, endCol)) {
      return new Node(grid[startRow][startCol] == 1, true, null, null, null, null);
    }

    Node root = new Node();
    root.isLeaf = false;

    // topLeft
    root.topLeft = construct(grid, startRow, (endRow - startRow + 1) / 2 + startRow - 1, startCol,
        (endCol - startCol + 1) / 2 + startCol - 1);

    // topRight
    root.topRight = construct(grid, startRow, (endRow - startRow + 1) / 2 + startRow - 1,
        (endCol - startCol + 1) / 2 + startCol, endCol);

    // buttomLeft
    root.bottomLeft = construct(grid, (endRow - startRow + 1) / 2 + startRow, endRow, startCol,
        (endCol - startCol + 1) / 2 + startCol - 1);

    // buttomRight
    root.bottomRight = construct(grid, (endRow - startRow + 1) / 2 + startRow, endRow,
        (endCol - startCol + 1) / 2 + startCol, endCol);

    return root;
  }

  private boolean isSameVal(int[][] grid, int startRow, int endRow, int startCol, int endCol) {
    int val = grid[startRow][startCol];
    for (int row = startRow; row <= endRow; row++) {
      for (int col = startCol; col <= endCol; col++) {
        if (grid[row][col] != val) {
          return false;
        }
      }
    }
    return true;
  }

  class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
    }

    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
      val = _val;
      isLeaf = _isLeaf;
      topLeft = _topLeft;
      topRight = _topRight;
      bottomLeft = _bottomLeft;
      bottomRight = _bottomRight;
    }
  }
}

