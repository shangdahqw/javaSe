package bishi;

import java.util.Scanner;

public class Didi02 {

  static int MAX = 10000000;

  /*请完成下面这个函数，实现题目要求的功能
  当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
  ******************************开始写代码******************************/
  static int find_cheapest_path(int N, int M, int[][] flights) {

    int[][] path = new int[N][N];
    int[] dis = new int[N];
    int[] vis = new int[N];

    for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) path[i][j] = path[j][i] = MAX;

    for (int i = 0; i < flights.length; i++) {
      int a = flights[i][0];
      int b = flights[i][1];

      path[a][b] = flights[i][3];
    }

    for (int i = 0; i < N; i++) {
      dis[i] = path[0][i];
      vis[i] = 0;
    }
    dis[0] = 0;
    vis[0] = 1;
    int k = 0, tmp;

    for (int i = 0; i < N - 1; i++) {

      tmp = MAX;
      for (int j = 0; j < N; j++)
        if (vis[j] == 0 && tmp > dis[j]) {

          tmp = dis[j];
          k = j;
        }

      vis[k] = 1;
      if (tmp == MAX) break;

      for (int j = 0; j < N; j++)
        if (vis[j] == 0 && dis[j] > dis[k] + path[k][j]) {

          dis[j] = dis[k] + path[k][j];
        }
    }

    return dis[1];
  }

  /** ****************************结束写代码***************************** */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int res;

    int _n;
    _n = Integer.parseInt(in.nextLine().trim());

    int _m;
    _m = Integer.parseInt(in.nextLine().trim());

    int _flights_rows = 0;
    int _flights_cols = 0;
    _flights_rows = Integer.parseInt(in.nextLine().trim());
    _flights_cols = Integer.parseInt(in.nextLine().trim());

    int[][] _flights = new int[_flights_rows][_flights_cols];
    for (int _flights_i = 0; _flights_i < _flights_rows; _flights_i++) {
      for (int _flights_j = 0; _flights_j < _flights_cols; _flights_j++) {
        _flights[_flights_i][_flights_j] = in.nextInt();
      }
    }

    if (in.hasNextLine()) {
      in.nextLine();
    }

    res = find_cheapest_path(_n, _m, _flights);
    System.out.println(String.valueOf(res));
  }
}
