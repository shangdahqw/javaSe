package bishi;

import java.util.Scanner;

/**
 * @Author huangqiangwen
 *
 * @create 2019/3/16 上午9:51 @Description
 */
public class toutiao02 {

  public static double eps = 1e-8;
  static int N, M;

  public static void main(String args[]) {

    Scanner in = new Scanner(System.in);

    N = in.nextInt();
    M = in.nextInt();
    int a[] = new int[N];

    double l = 0, r = 0;
    for (int i = 0; i < N; i++) {
      a[i] = in.nextInt();
      l = Math.min(l, a[i]);
      r = Math.max(r, a[i]);
    }
    solve(l, r, a);
  }

  public static void solve(double l, double r, int[] a) {
    double mid;
    while (l + eps < r) {
      mid = (l + r) / 2.0;
      if (check(mid, a)) {
        l = mid;
      } else r = mid;
    }
    String res = String.format("%.2f", (r * 100) / 100.0);
    System.out.println(res);
  }

  public static Boolean check(double x, int[] a) {
    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += a[i] / x;
    }
    return sum >= M;
  }
}
