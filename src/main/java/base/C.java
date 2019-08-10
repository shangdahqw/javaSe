package base;

abstract class B {
  B() {
    System.out.println("b init");
  }
}

class C extends B {
  C() {
    super();
    System.out.println("c init");
  }

  public static void main(String ars[]) {

    C b = new C();
  }
}
