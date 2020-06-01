// 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
// 示例：
// 输入: S = "ADOBECODEBANC", T = "ABC"
// 输出: "BANC"

class Solution {
  Map<Character, Integer> dic = new HashMap<Character, Integer>();
  Map<Character, Integer> counts = new HashMap<Character, Integer>();

  public String minWindow(String s, String t) {
    if ("".equals(s) || "".equals(t))
      return "";
    int tLength = t.length();
    if (tLength > s.length())
      return "";
    int head = 0, back = 0;
    int minHead = 0, minBack = 0;
    int min = s.length() + 1;
    // 初始化
    for (int i = 0; i < tLength; i++) {
      char c = t.charAt(i);
      dic.put(c, dic.getOrDefault(c, 0) + 1);
    }
    // 计数
    int count = 0;
    // 循环用
    boolean isHead = false;
    int p = 0;
    while (p < s.length()) {
      char c = s.charAt(p);
      p++;
      if (!dic.containsKey(c))
        continue;
      if (isHead) {
        head = p;
        if (back - head + 2 < min) {
          minHead = head - 1;
          minBack = back;
          min = minBack - minHead + 1;
        }
        counts.put(c, counts.get(c) - 1);
        if (isFill(c) == -1) {
          count--;
          isHead = false;
          p = back + 1;
        }
      } else {
        back = p - 1;
        counts.put(c, counts.getOrDefault(c, 0) + 1);
        if (isFill(c) != 1) {
          count++;
        }
        if (count == tLength) {
          isHead = true;
          p = head;
          if (back - head + 1 < min) {
            minHead = head;
            minBack = back;
            min = minBack - minHead + 1;
          }
        }
      }
    }
    if (min == s.length() + 1)
      return "";
    return s.substring(minHead, minBack + 1);
  }

  int isFill(char c) {
    if (counts.get(c) > dic.get(c)) {
      return 1;
    } else if (counts.get(c).equals(dic.get(c))) {
      return 0;
    }
    return -1;
  }
}