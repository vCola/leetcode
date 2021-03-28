package com.vcola.leetcode.puzzle;

import java.util.Arrays;

/**
 * 443. 压缩字符串
 *
 * @author Very Cola
 * @date 2018年11月16日 上午9:23:44
 */
public class StringCompression {

  public int compress(char[] chars) {
    int result = 0;
    int counter = 0;
    char preChar = chars[0], currentChar;
    int lengthOfChars = chars.length;

    int newIndex = 0;

    for (int index = 0; index < lengthOfChars; index++) {
      currentChar = chars[index];
      if (preChar == currentChar) {
        counter++;
      } else {
        chars[newIndex++] = preChar;
        if (counter == 1) {
          result += 1;
        } else {
          int bit = ("" + counter).length() + 1;
          result += bit;
          for (char c : ("" + counter).toCharArray()) {
            chars[newIndex++] = c;
          }
        }
        counter = 1;
        preChar = currentChar;
      }

      if (index + 1 == lengthOfChars) {
        chars[newIndex++] = preChar;
        if (counter == 1) {
          result += 1;
        } else {
          int bit = ("" + counter).length() + 1;
          result += bit;
          for (char c : ("" + counter).toCharArray()) {
            chars[newIndex++] = c;
          }
        }
      }
    }
    return result;
  }

	/*private int count(int counter) {
		if(counter == 1){
			return 1;
		} 
		int bit = 1;
		while(counter/10 != 0){
			bit++;
			counter /= 10;
		}
		return bit + 1;
	}*/

  public static void main(String[] args) {
    char[] chars = { 'a', 'c' };
    StringCompression stringCompression = new StringCompression();
    System.out.println(stringCompression.compress(chars));
    System.out.println(Arrays.toString(chars));
  }

}
