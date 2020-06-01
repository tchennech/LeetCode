public class P51Queen {
}

class Solution {
  // 主对角线元素相减相等(lead_diag)，次对角线元素相加相等(rev_diag)。
  // 深搜遍历、剪枝
  // n个皇后在每行（或者列，思路一样）
  // 每个皇后在自己的行遍历n个列的位置（前提是不能被上面的皇后干掉）
  // 遍历完n个皇后则总数++

  // 计数
  private int count;
  // n个皇后
  private int n;
  // 列，主对角线，反对角线
  private int[] occupy_col, lead_diag, rev_diag;

  // 判断当前点是否可落
  private boolean is_occupy(int row, int col) {
    return (occupy_col[col] + lead_diag[row - col + n] + rev_diag[row + col]) > 0 ? true : false;
  }

  private void dfs(int now_row) {
    for (int col = 0; col < n; col++) {
      // 占位了就直接继续
      if (is_occupy(now_row, col))
        continue;
      // 占位
      occupy_col[col] = 1;
      lead_diag[now_row - col + n] = 1;
      rev_diag[now_row + col] = 1;
      // 判断是不是走完了全部皇后，否则下一个皇后
      if (now_row + 1 == n) {
        count++;
      } else {
        dfs(now_row + 1);
      }
      // 取消这个，并复位
      occupy_col[col] = 0;
      lead_diag[now_row - col + n] = 0;
      rev_diag[now_row + col] = 0;
    }
  }

  public int totalNQueens(int n) {
    this.n = n;
    count = 0;
    occupy_col = new int[n];
    lead_diag = new int[2 * n];
    rev_diag = new int[2 * n];
    dfs(0);
    return count;
  }
}