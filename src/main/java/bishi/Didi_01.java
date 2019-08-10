package bishi;

import java.util.Scanner;

public class Didi_01 {

  static int MAX = 1000;
  static int N;
  static int M;

  public static void main(String args[]) {

    Scanner cin = new Scanner(System.in);

    N = cin.nextInt();
    M = cin.nextInt();
    int[][] path = new int[N + 1][N + 1];
    int[] dis = new int[N + 1];
    int[] vis = new int[N + 1];

    for (int i = 1; i <= N; i++) for (int j = 1; j <= N; j++) path[i][j] = path[j][i] = MAX;

    for (int i = 0; i < M; i++) {

      int a = cin.nextInt();
      int b = cin.nextInt();
      path[a][b] = path[b][a] = cin.nextInt();
    }

    System.out.println(Prim(dis, vis, path));
  }

  private static int Prim(int[] dis, int[] vis, int[][] path) {

    for (int i = 1; i <= N; i++) {
      dis[i] = path[1][i];
      vis[i] = 0;
    }
    dis[1] = 0;
    vis[1] = 1;
    int k = 0, tmp;

    for (int i = 1; i < N; i++) {

      tmp = MAX;
      for (int j = 1; j <= N; j++)
        if (vis[j] == 0 && tmp > dis[j]) {

          tmp = dis[j];
          k = j;
        }

      vis[k] = 1;
      if (tmp == MAX) break;

      for (int j = 1; j <= N; j++)
        if (vis[j] == 0 && dis[j] > dis[k] + path[k][j]) {

          dis[j] = dis[k] + path[k][j];
        }
    }

    return dis[N];
  }
}
