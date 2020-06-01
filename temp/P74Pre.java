// 前缀和用pre[i] = A[0] + ... + A[i]表示
// 根据同余定理，若 (a-b) % k == 0; 那么 a % k == b % k;
// 而子数组可以表示为pre[i] - pre [j]表示
// 因此只要证明 pre[i] 和 pre[j] 同余即可
// 同时要消除负数的影响
class Solution {
  public int subarraysDivByK(int[] A, int K) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = A.length;
    int pre = 0;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      pre += A[i];
      int pos = (pre % K + K) % K;
      if (pos == 0)
        ans++;
      map.put(pos, map.getOrDefault(pos, 0) + 1);
      ans += (map.get(pos) - 1);
    }
    return ans;
  }
}