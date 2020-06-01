class P50Two {
}

class Solution {
  // 快速幂，二分
  public double fastPow(double x, int n) {
    if (n == 0) {
      return 1;
    }
    double temp_result = fastPow(x, n / 2);
    return n % 2 == 0 ? temp_result * temp_result : x * temp_result * temp_result;
  }

  public double myPow(double x, int n) {
    return n > 0 ? fastPow(x, n) : 1 / fastPow(x, -n);
  }
}