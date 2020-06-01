public class P210Pic {

}

class Solution {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> G = new ArrayList<List<Integer>>();
    int[] inDe = new int[numCourses];
    int num = 0;
    List<Integer> result = new ArrayList<Integer>();
    Queue<Integer> que = new LinkedList<Integer>();
    // 初始化邻接表
    for (int i = 0; i < numCourses; i++) {
      G.add(new ArrayList<Integer>());
    }
    // 初始化邻接表
    for (int i = 0; i < prerequisites.length; i++) {
      List<Integer> temp = G.get(prerequisites[i][1]);
      temp.add(prerequisites[i][0]);
      G.set(prerequisites[i][1], temp);
      inDe[prerequisites[i][0]] += 1;
    }
    for (int i = 0; i < numCourses; i++) {
      if (inDe[i] == 0) {
        que.offer(i);
        num++;
      }
    }
    while (!que.isEmpty()) {
      int temp = que.poll();
      result.add(temp);
      for (int i : G.get(temp)) {
        inDe[i] -= 1;
        if (inDe[i] == 0) {
          que.offer(i);
          num++;
        }
      }
    }
    if (num != numCourses) {
      int[] x = new int[0];
      return x;
    }
    int[] res = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      res[i] = result.get(i);
    }
    return res;
  }
}