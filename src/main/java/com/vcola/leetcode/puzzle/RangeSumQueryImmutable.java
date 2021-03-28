package com.vcola.leetcode.puzzle;

/**
 * 303. 区域和检索 - 数组不可变
 *
 * @author Very Cola
 * @date 2018年9月13日 下午5:40:50
 */
public class RangeSumQueryImmutable {

  private int[] nums;

  public RangeSumQueryImmutable(int[] nums) {
    if (nums == null || nums.length == 0) {
      this.nums = new int[0];
      return;
    }
    this.nums = new int[nums.length];
    this.nums[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      this.nums[i] = this.nums[i - 1] + nums[i];

    }
  }

  public int sumRange(int i, int j) {
    if (i == 0) {
      return nums[j];
    } else {
      return nums[j] - nums[i - 1];
    }
  }

  public static void main(String[] args) {
    int[] nums = { -2, 0, 3, -5, 2, -1 };
    RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable(nums);
    System.out.println(rangeSumQueryImmutable.sumRange(1, 3));
  }

  // timeout
	/*public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
    }
	
	public int sumRange(int i, int j) {
		int result = 0;
		while(i <= j && i<nums.length){
			result += nums[i++];
		}
		return result;
	}*/
}
