public class P1371_good_奇偶性_位操作 {

}
// 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u'
// ，在子字符串中都恰好出现了偶数次。
// 示例 1：
// 输入：s = "eleetminicoworoep"
// 输出：13
// 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。

class Solution {
  public int findTheLongestSubstring(String s) {
    // 偶数减偶数为偶，奇数减奇数为偶
    // 用0,记录出现次数为偶数，用1记录出现为奇数。所以00000 这五个元音的状态，记为一个状态。
    // pos记录出现状态最早的位置，转换成10进制需要2^5个位置。
    int[] pos = new int[1 << 5];
    Arrays.fill(pos, -1);
    pos[0] = 0; // 一定注意
    // 记录元音当前位置的状态
    // 相同为1，不相同为0
    int sta = 0;
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      char x = s.charAt(i);
      switch (x) {
        case 'a':
          sta ^= (1 << 0);
          break;
        case 'e':
          sta ^= (1 << 1);
          break;
        case 'i':
          sta ^= (1 << 2);
          break;
        case 'o':
          sta ^= (1 << 3);
          break;
        case 'u':
          sta ^= (1 << 4);
          break;
      }
      if (pos[sta] >= 0) {
        ans = Math.max(ans, i + 1 - pos[sta]);
      } else {
        pos[sta] = i + 1;
      }
    }
    return ans;
  }
}
