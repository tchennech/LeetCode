public class P1402DP {

}

class Solution {
  public int maxSatisfaction(int[] satisfaction) {

    int n = satisfaction.length;

    Arrays.sort(satisfaction);

    int max = 0;
    for (int i = 1; i <= n; i++) {
      int i_result = 0;
      for (int j = 0; j < i; j++) {
        i_result += satisfaction[n - 1 - j] * (i - j);
      }
      if (i_result < 0)
        break;
      max = max > i_result ? max : i_result;
    }
    return max;
  }
}