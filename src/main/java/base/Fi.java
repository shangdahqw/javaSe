package base;

public final class Fi {
  int a;
  final int b = 0;
  Integer s;

  public static void main(String args[]) {

    // 引用没有被final修饰，所以是可变的。
    // final只修饰了Fi类型，即Fi实例化的对象在堆中内存地址是不可变的。
    // 虽然内存地址不可变，但是可以对内部的数据做改变。
    Fi f = new Fi();
    f.a = 1;
    System.out.println(f);
    f.a = 2;
    System.out.println(f);
    // 改变实例中的值并不改变内存地址。

    Fi ff = f;
    // 让引用指向新的Fi对象，原来的f对象由新的引用ff持有。
    // 引用的指向改变也不会改变原来对象的地址
    f = new Fi();
    System.out.println(f);
    System.out.println(ff);
  }

  //		com1.Fi@33909752
  //		com1.Fi@33909752
  //		com1.Fi@55f96302
  //		com1.Fi@33909752
}
