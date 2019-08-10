package bishi;

import java.util.Scanner;

/**
 * @Author huangqiangwen
 *
 * @create 2019/3/16 上午9:51 @Description
 */
public class toutiao01 {

  public static void main(String args[]) {

    Scanner in = new Scanner(System.in);

    int N = in.nextInt();
    int arr[] = {1, 4, 16, 64};
    System.out.println(result(arr, 1024 - N));
  }

  public static int result(int[] arr, int k) {
    if (arr == null || arr.length == 0 || k < 1) {
      return 0;
    }
    int[][] minarr = new int[k + 1][arr.length + 1];
    for (int i = 1; i <= k; i++) {
      for (int j = 0; j < arr.length; j++) {
        int coin = i - arr[j];
        if (coin > -1) {
          minarr[i][j] = minarr[coin][arr.length] + 1;
          if (minarr[i][arr.length] == 0
              || minarr[i][j] < minarr[i][arr.length]) { // 如果当前的硬币数目是最少的, 更新min列的最少硬币数目
            minarr[i][arr.length] = minarr[i][j];
          }
        }
      }
    }
    return minarr[k][arr.length];
  }
}
