package thread.AbstractQueuedSynchronizer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DEMO {
  private static ReentrantLock lock = new ReentrantLock();
  private static Condition condition = lock.newCondition();

  public static void main(String[] args) throws InterruptedException {
    Thread t1 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                lock.lock();
                // 1.线程1获取锁成功
                try {
                  condition.await(); // 3.线程1释放锁，并且加入condition队列，此时syn队列头节点即线程2被唤醒
                  // 6.线程1被唤醒继续执行
                } catch (InterruptedException e) {
                  e.printStackTrace();
                } finally {
                  lock.unlock();
                }
              }
            });
    t1.start();
    Thread.sleep(1000);
    Thread t2 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  lock.lock(); // 2.线程2申请获取锁资源，失败，加入syn队列
                  condition.signal(); // 4.线程2唤醒condition队列中的头节点即线程1，线程1进入syn队列
                } finally {
                  lock.unlock(); // 5.线程2释放锁资源，唤醒syn队列头节点
                }
              }
            });
    t2.start();
  }
}
