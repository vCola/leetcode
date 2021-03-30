package com.vcola.leetcode.puzzle;

/**
 * 67. 二进制求和
 */
public class AddBinary_67 {

  public String addBinary(String a, String b) {
    StringBuilder result = new StringBuilder();
    int temp = 0;
    for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
      int sum = temp;
      sum += i >= 0 ? a.charAt(i) - '0' : 0;
      sum += j >= 0 ? b.charAt(j) - '0' : 0;
      result.append(sum % 2);
      temp = sum / 2;
    }
    result.append(temp == 1 ? temp : "");
    return result.reverse().toString();
  }

  public String addBinaryV1(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int indexA = a.length() - 1;
    int indexB = b.length() - 1;
    int add = 0;
    while (indexA >= 0 || indexB >= 0) {
      int intA = 0;
      int intB = 0;

      if (indexA >= 0) {
        intA = a.charAt(indexA) - '0';
      }
      if (indexB >= 0) {
        intB = b.charAt(indexB) - '0';
      }

      int temp = add + intA + intB;
      if (temp >= 2) {
        add = 1;
      } else {
        add = 0;
      }
      sb.insert(0, temp % 2 + "");
      indexA--;
      indexB--;
    }

    if (add > 0) {
      sb.insert(0, add);
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    AddBinary_67 addBinary = new AddBinary_67();
    String a = "1010";
    String b = "1011";
    System.out.println(addBinary.addBinary(a, b));
  }

}
