package thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

  public static void newThread(String name, Future<Integer> future) {
    new Thread(
            new Runnable() {
              @Override
              public void run() {
                System.out.println("线程" + Thread.currentThread().getName() + "开始运行");
                try {
                  int result = future.get();
                  System.out.println(
                      "线程" + Thread.currentThread().getName() + "获取结果  result==" + result);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                } catch (ExecutionException e) {
                  e.printStackTrace();
                }
              }
            },
            name)
        .start();
  }

  public static void main(String[] args) {

    FutureTask<Integer> future =
        new FutureTask<Integer>(
            new Callable<Integer>() {
              @Override
              public Integer call() throws Exception {
                System.out.println("线程" + Thread.currentThread().getName() + "运行任务");
                Thread.sleep(1000);
                System.out.println("线程" + Thread.currentThread().getName() + "任务运行完成");
                return 100;
              }
            });

    new Thread(
            new Runnable() {
              @Override
              public void run() {
                future.run();
              }
            },
            "t10")
        .start();

    newThread("t1", future);
    newThread("t2", future);
    newThread("t3", future);
    newThread("t4", future);
  }
}
