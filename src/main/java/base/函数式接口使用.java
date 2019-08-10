package base;

import org.junit.Test;

public class 函数式接口使用 {
  @FunctionalInterface
  interface A {
    void say();

    default void talk() {}
  }

  @Test
  public void test1() {
    A a = () -> System.out.println("hello");
    a.say();
  }

  @FunctionalInterface
  interface B {
    void say(String i);
  }

  public void test2() {
    // 下面两个是等价的，都是通过B接口来引用一个方法，而方法可以直接使用::来作为方法引用
    B b = System.out::println;
    B b1 = a -> Integer.parseInt("s"); // 这里的a其实换成别的也行，只是将方法传给接口作为其方法实现
    B b2 = Integer::valueOf; // i与方法传入参数的变量类型一直时，可以直接替换
    B b3 = String::valueOf;
    // B b4 = Integer::parseInt;类型不符，无法使用

  }

  @FunctionalInterface
  interface C {
    int say(String i);
  }

  @Test
  public void test3() {
    C c = Integer::parseInt; // 方法参数和接口方法的参数一样，可以替换。
    int i = c.say("1");
    // 当我把C接口的int替换为void时就会报错，因为返回类型不一致。
    System.out.println(i);
    // 综上所述，lambda表达式提供了一种简便的表达方式，可以将一个方法传到接口中。
    // 函数式接口是只提供一个抽象方法的接口，其方法由lambda表达式注入，不需要写实现类，
    // 也不需要写匿名内部类，可以省去很多代码，比如实现runnable接口。
    // 函数式编程就是指把方法当做一个参数或引用来进行操作。除了普通方法以外，静态方法，构造方法也是可以这样操作的。
  }
}
