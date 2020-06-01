public class P19two {

}

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode p1 = head;
    ListNode p2 = head;

    while (n-- != 0) {
      p1 = p1.next;
    }
    if (p1 != null) {
      while (p1.next != null) {
        p1 = p1.next;
        p2 = p2.next;
      }
      p2.next = p2.next.next;
    } else {
      head = head.next;
    }
    return head;
  }
}