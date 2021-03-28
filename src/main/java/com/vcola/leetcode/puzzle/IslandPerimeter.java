package com.vcola.leetcode.puzzle;

/**
 * 463. 岛屿的周长
 *
 * @author Very Cola
 * @date 2018年11月29日 下午2:03:33
 */
public class IslandPerimeter {

  public int islandPerimeter(int[][] grid) {
    int result = 0;

    int landCell = 0;
    int preLandCell = 0;
    int intersectionLandCell = 0;

    int hightLandCell = 0;

    int rowSize = grid.length;
    int colSize = grid[0].length;

    for (int row = 0; row < rowSize; row++) {
      landCell = 0;
      intersectionLandCell = 0;
      hightLandCell = 0;

      for (int col = 0; col < colSize; col++) {
        if (grid[row][col] == 1) {
          landCell++;

          if (row > 0 && grid[row - 1][col] == 1) {
            intersectionLandCell++;
          }

          if (col == 0 || grid[row][col - 1] != 1) {
            hightLandCell++;
          }

        }
      }

      if (landCell > 0) {
        result += (2 * hightLandCell + (landCell + preLandCell) - 2 * intersectionLandCell);
        preLandCell = landCell;
      }
    }

    result += preLandCell;
    return result;
  }

  public static void main(String[] args) {
    int[][] grid = { { 1, 1, 1 }, { 1, 0, 1 } };
    IslandPerimeter islandPerimeter = new IslandPerimeter();
    System.out.println(islandPerimeter.islandPerimeter(grid));
  }

}
