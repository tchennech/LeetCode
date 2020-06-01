public class P1289DP {

}

class Solution {
  public int minFallingPathSum(int[][] arr) {
    int lastMin = 0;
    int lastSecMin = 0;
    int lastPos = -1;
    for (int i = 0; i < arr.length; i++) {
      int nowMin = lastMin + 100;
      int nowSecMin = lastSecMin + 100;
      int nowPow = -1;
      for (int j = 0; j < arr[i].length; j++) {
        if (j == lastPos) {
          if (nowMin > lastSecMin + arr[i][j]) {
            nowSecMin = nowMin;
            nowMin = lastSecMin + arr[i][j];
            nowPow = j;
          } else {
            nowSecMin = nowSecMin > lastSecMin + arr[i][j] ? lastSecMin + arr[i][j] : nowSecMin;
          }
        } else {
          if (nowMin > lastMin + arr[i][j]) {
            nowSecMin = nowMin;
            nowMin = lastMin + arr[i][j];
            nowPow = j;
          } else {
            nowSecMin = nowSecMin > lastMin + arr[i][j] ? lastMin + arr[i][j] : nowSecMin;
          }

        }
      }
      lastMin = nowMin;
      lastSecMin = nowSecMin;
      lastPos = nowPow;
    }
    return lastMin;
  }
}