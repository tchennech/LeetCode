public class P145Tree {

}

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  // 他人想法，非常good
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while (!stack.empty()) {
      TreeNode node = stack.pop();
      if (node != null) {
        // 只需要调换位置就可以实现先序、中序、后序。
        stack.push(node);
        stack.push(null);
        if (node.right != null)
          stack.push(node.right);
        if (node.left != null)
          stack.push(node.left);
      } else {
        result.add(stack.pop().val);
      }
    }
    return result;
  }
}