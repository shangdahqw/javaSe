package base;

import org.junit.Test;

public class 异常链 {
  @Test
  public void test() {
    C();
  }

  public void A() throws Exception {
    try {
      int i = 1;
      i = i / 0;

    } catch (ArithmeticException e) {
      // 这里通过throwable类的构造方法将最底层的异常重新包装并抛出，此时注入了A方法的信息。最后打印栈信息时可以看到caused by
      // A方法的异常。
      // 如果直接抛出，栈信息打印结果只能看到上层方法的错误信息，不能看到其实是A发生了错误。
      // 所以需要包装并抛出
      throw new Exception("A方法计算错误", e);
    }
  }

  public void B() throws Exception, Error {
    try {
      // 接收到A的异常，
      A();
    } catch (Exception e) {
      throw e;
    } catch (Error error) {
      throw new Error("B也犯了个错误", error);
    }
  }

  public void C() {
    try {
      B();
    } catch (Exception | Error e) {
      e.printStackTrace();
    }
  }

  // 最后结果
  //    java.lang.Exception: A方法计算错误
  //    at com.javase.异常.异常链.A(异常链.java:18)
  //    at com.javase.异常.异常链.B(异常链.java:24)
  //    at com.javase.异常.异常链.C(异常链.java:31)
  //    at com.javase.异常.异常链.test(异常链.java:11)
  //    省略
  //    Caused by: java.lang.ArithmeticException: / by zero
  //    at com.javase.异常.异常链.A(异常链.java:16)
  //            ... 31 more
}
