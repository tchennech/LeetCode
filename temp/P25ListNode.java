/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  private ListNode[] reverseK(ListNode head, int k) {
    ListNode p = head;
    ListNode last = null;
    ListNode next = null;
    int i;
    for (i = 0; i < k && p != null; i++) {
      // 保存下一个
      next = p.next;
      // 反转
      p.next = last;
      // 保存上一个
      last = p;
      // next
      p = next;
    }
    p = last;
    ListNode[] result = new ListNode[2];
    result[0] = p;
    result[1] = next;
    // 如果不够k个则反转回来
    if (i != k) {
      result = reverseK(p, i);
    }

    return result;
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode p = head;
    // head 特殊处理
    if (p == null) {
      return head;
    }
    ListNode[] temp = reverseK(p, k);
    p = temp[1];
    ListNode last = head;
    head = temp[0];
    // 后面的所有
    while (true) {
      if (p == null) {
        break;
      }
      temp = reverseK(p, k);
      last.next = temp[0];
      last = p;
      p = temp[1];
    }
    return head;
  }
}