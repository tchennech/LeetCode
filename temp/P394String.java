// 给定一个经过编码的字符串，返回它解码后的字符串。
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

// "3[a2[c]]" =》 "accaccacc"
class Solution {
  public String decodeString(String s) {
    String num = "";
    String ans = "";
    String tAns = "";
    String xAns = "";
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char t = s.charAt(i);
      if ('0' <= t && t <= '9') {
        if (!"".equals(tAns)) {
          stack.push(tAns);
          tAns = "";
        }
        num += String.valueOf(t);
        continue;
      } else if (t == '[') {
        stack.push(num);
        num = "";
        stack.push("[");
        continue;
      } else if (t == ']') {
        while (!"[".equals(stack.peek())) {
          tAns = stack.pop() + tAns;
        }
        stack.pop();
        num = stack.pop();
        int inum = Integer.valueOf(num);
        for (int j = 0; j < inum; j++) {
          xAns += tAns;
        }
        stack.push(xAns);
        tAns = "";
        num = "";
        xAns = "";
        continue;
      }
      tAns += String.valueOf(t);
    }
    ans = tAns;
    while (!stack.empty()) {
      ans = stack.pop() + ans;
    }

    return ans;
  }
}