// 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
// 你可以假设 nums1 和 nums2 不会同时为空。
class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int count = 0;
    int firstMis;
    int secMis = -1;
    float ans = 0;
    if ((nums1.length + nums2.length) % 2 == 0) {
      secMis = (nums1.length + nums2.length) / 2;
      firstMis = secMis - 1;
    } else {
      firstMis = (nums1.length + nums2.length) / 2;
    }
    int i = 0, j = 0;
    int tempMin = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        tempMin = nums1[i];
        i++;
      } else {
        tempMin = nums2[j];
        j++;
      }
      count++;
      if (count - 1 == firstMis) {
        ans = (float) tempMin;
        firstMis = -1;
        if (secMis == -1)
          break;
      } else if (count - 1 == secMis) {
        ans += tempMin;
        ans /= 2;
        secMis = -1;
        break;
      }
    }
    if (firstMis == -1 && secMis == -1)
      return ans;
    if (j >= nums2.length) {
      while (i < nums1.length) {
        count++;
        if (count - 1 == firstMis) {
          ans = (float) nums1[i];
          firstMis = -1;
          if (secMis == -1)
            break;
        } else if (count - 1 == secMis) {
          ans += (float) nums1[i];
          ans /= 2;
          secMis = -1;
          break;
        }
        i++;
      }
    } else {
      while (j < nums2.length) {
        count++;
        if (count - 1 == firstMis) {
          ans = (float) nums2[j];
          firstMis = -1;
          if (secMis == -1)
            break;
        } else if (count - 1 == secMis) {
          ans += (float) nums2[j];
          ans /= 2;
          secMis = -1;
          break;
        }
        j++;
      }
    }
    return ans;
  }
}