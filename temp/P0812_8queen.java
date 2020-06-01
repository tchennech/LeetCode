//和p51类似
class Solution {
  // 与n皇后类似，不过加上一个深搜的路径记录。
  public boolean valid_ocuppy(int row, int col, int n, int[] occu_col, int[] main_diag, int[] subor_diag) {
    return (occu_col[col] + main_diag[row - col + n] + subor_diag[row + col]) > 0 ? true : false;
  }

  public void dfs(int row, int n, int[] occu_col, int[] main_diag, int[] subor_diag, int[] queen,
      List<List<String>> result) {
    if (row == n) {
      List<String> one_solution = new ArrayList<String>();
      for (int i = 0; i < n; i++) {
        int index = queen[i];
        StringBuilder line = new StringBuilder(new String(new char[n]).replace('\0', '.'));
        one_solution.add(line.replace(index, index + 1, "Q").toString());
      }
      result.add(one_solution);
      return;
    }
    for (int col = 0; col < n; col++) {
      if (valid_ocuppy(row, col, n, occu_col, main_diag, subor_diag)) {
        continue;
      }
      occu_col[col] = 1;
      main_diag[row - col + n] = 1;
      subor_diag[row + col] = 1;
      queen[row] = col;
      dfs(row + 1, n, occu_col, main_diag, subor_diag, queen, result);
      occu_col[col] = 0;
      main_diag[row - col + n] = 0;
      subor_diag[row + col] = 0;
      queen[row] = 0;
    }
  }

  public List<List<String>> solveNQueens(int n) {
    int[] main_diag = new int[2 * n];
    int[] subor_diag = new int[2 * n];
    int[] occu_col = new int[n];
    int[] queen = new int[n];
    List<List<String>> result = new ArrayList<List<String>>();
    dfs(0, n, occu_col, main_diag, subor_diag, queen, result);
    return result;
  }
}