package bishi;

/**
 * @Author huangqiangwen
 *
 * @create 2019/3/16 上午9:51 @Description
 */
public class toutiao03 {

  public static double eps = 1e-8;
  static int N, M;

  public static void main(String args[]) {

    //    Scanner in = new Scanner(System.in);
    //
    //    N = in.nextInt();
    //    String[] a = new String[N];
    //    for (int i = 0; i < N; i++) {
    //      a[i] = in.nextLine();
    //
    //      StringBuffer res = new StringBuffer();
    //      char[] b = a[i].toCharArray();
    //
    //      res.append(b[0]);
    //      int c = 1;
    //      for (int j = 1; j < N; j++) {
    //
    //        if (b[j] == b[j - 1]) c++;
    //        if (c < 3) {
    //          res.append(b[j]);
    //        } else c = 1;
    //      }
    //      System.out.println(res.toString());
    //    }

    String str = "a,b,c,,";
    String[] ary = str.split(",");
    // 预期大于3，结果是3
    System.out.println(ary.length);
  }
}
