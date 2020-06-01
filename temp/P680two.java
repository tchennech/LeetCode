public class P680two {

}

// 判断回文字
class Solution {
  public boolean validPalindromeChild(String s, int head, int back) {
    while (head < back) {
      if (s.charAt(head) != s.charAt(back))
        break;
      head++;
      back--;
    }
    return head >= back;
  }

  public boolean validPalindrome(String s) {
    int head = 0;
    int back = s.length() - 1;
    boolean isDel = false;
    while (head < back) {
      if (s.charAt(head) != s.charAt(back)) {
        boolean l = validPalindromeChild(s, head + 1, back);
        boolean r = validPalindromeChild(s, head, back - 1);
        if (l || r) {
          head = back;
        }
        break;
      }
      head++;
      back--;
    }
    if (head >= back) {
      return true;
    }
    return false;
  }
}