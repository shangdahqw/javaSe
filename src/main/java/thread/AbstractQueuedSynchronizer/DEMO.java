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
                // 1.�߳�1��ȡ���ɹ�
                try {
                  condition.await(); // 3.�߳�1�ͷ��������Ҽ���condition���У���ʱsyn����ͷ�ڵ㼴�߳�2������
                  // 6.�߳�1�����Ѽ���ִ��
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
                  lock.lock(); // 2.�߳�2�����ȡ����Դ��ʧ�ܣ�����syn����
                  condition.signal(); // 4.�߳�2����condition�����е�ͷ�ڵ㼴�߳�1���߳�1����syn����
                } finally {
                  lock.unlock(); // 5.�߳�2�ͷ�����Դ������syn����ͷ�ڵ�
                }
              }
            });
    t2.start();
  }
}
