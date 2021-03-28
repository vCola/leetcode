package com.vcola.leetcode.puzzle;

/**
 * 482. 密钥格式化
 *
 * @author Very Cola
 * @date 2018年12月13日 上午9:40:30
 */
public class LicenseKeyFormatting {

  public String licenseKeyFormatting(String S, int K) {
    S = S.replace("-", "").toUpperCase();
    int length = S.length();
    if (length <= K) {
      return S;
    }

    int index = 0;
    StringBuilder sb = new StringBuilder();
    int mod = length % K;
    if (mod != 0) {
      sb.append(S.substring(0, mod)).append("-");
      index += mod;
    }

    for (int i = index; i < length; i += K) {
      sb.append(S.substring(i, i + K)).append("-");
    }

    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  public static void main(String[] args) {
    String S = "2-5g-3-J";
    int K = 2;

    LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
    System.out.println(licenseKeyFormatting.licenseKeyFormatting(S, K));
  }
}
