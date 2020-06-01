public class P152DP {

}

class Solution {
  private int maxThree(int a, int b, int c) {
    int max_ = a;
    max_ = Math.max(max_, b);
    max_ = Math.max(max_, c);
    return max_;
  }

  private int minThree(int a, int b, int c) {
    int min_ = a;
    min_ = Math.min(min_, b);
    min_ = Math.min(min_, c);
    return min_;
  }

  public int maxProduct(int[] nums) {
    // 上一步中，乘积最大
    int dp_p = nums[0];
    // 上一步中，乘积最小
    int dp_n = nums[0];
    int max_ = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int p_temp = dp_p * nums[i];
      int n_temp = dp_n * nums[i];
      dp_p = maxThree(p_temp, n_temp, nums[i]);
      dp_n = minThree(p_temp, n_temp, nums[i]);
      max_ = Math.max(max_, dp_p);
    }
    return max_;
  }
}