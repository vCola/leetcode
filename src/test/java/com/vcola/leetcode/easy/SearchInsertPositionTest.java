package com.vcola.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import com.vcola.leetcode.puzzle.SearchInsertPosition;

public class SearchInsertPositionTest {

  private SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

  @Test
  public void testSearchInsertHave() {
    int[] nums = { 1, 3, 5, 6 };
    int target = 5;
    Assert.assertEquals(2, searchInsertPosition.searchInsert(nums, target));
  }

  @Test
  public void testSearchInsertNotHave() {
    int[] nums = { 1, 3, 5, 6 };
    int target = 2;
    Assert.assertEquals(1, searchInsertPosition.searchInsert(nums, target));
  }

  @Test
  public void testSearchInsertNotHave01() {
    int[] nums = { 1, 3, 5, 6 };
    int target = 7;
    Assert.assertEquals(4, searchInsertPosition.searchInsert(nums, target));
  }

  @Test
  public void testSearchInsertNotHave02() {
    int[] nums = { 3, 5, 7, 9, 10 };
    int target = 8;
    Assert.assertEquals(3, searchInsertPosition.searchInsert(nums, target));
  }

}
