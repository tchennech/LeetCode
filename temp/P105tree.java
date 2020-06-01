/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
// 根据先序和中序构建二叉树
class Solution {
  int[] preorder;
  int[] inorder;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    this.preorder = preorder;
    this.inorder = inorder;
    TreeNode ans = null;
    if (preorder.length == 0)
      return ans;
    return buildChild(0, preorder.length - 1, 0, inorder.length - 1);
  }

  public TreeNode buildChild(int pStart, int pEnd, int iStar, int iEnd) {
    // System.out.println(pStart);
    TreeNode root = new TreeNode(preorder[pStart]);
    int rootI;
    for (rootI = iStar; rootI < iEnd; rootI++) {
      if (root.val == inorder[rootI]) {
        break;
      }
    }
    if (rootI == iStar)
      root.left = null;
    else
      root.left = buildChild(pStart + 1, pStart + rootI - iStar, iStar, rootI - 1);
    if (rootI == iEnd)
      root.right = null;
    else
      root.right = buildChild(pStart + rootI + 1 - iStar, pEnd, rootI + 1, iEnd);
    return root;
  }
}