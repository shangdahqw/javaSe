package base;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ArrayList的序列化 {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    //        ArrayList list = new ArrayList();
    //        list.add("a");
    //        list.add("b");
    //        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new
    // FileOutputStream("arr.txt"));
    //        objectOutputStream.writeObject(list);
    //        objectOutputStream.close();
    //        ObjectInputStream objectInputStream = new ObjectInputStream(new
    // FileInputStream("arr.txt"));
    //        ArrayList list1 = (ArrayList) objectInputStream.readObject();
    //        objectInputStream.close();
    //        System.out.println(Arrays.toString(list1.toArray()));
    //        //序列化成功，里面的元素保持不变。

    Arrays.asList("a", "b", "d")
        .forEach(
            e -> {
              System.out.print(e);
              System.out.print(e);
            });

    List list = Arrays.asList("f", "c", "a");
    list.sort(
        (e1, e2) -> {
          int result = ((String) e1).compareTo((String) e2);
          return result;
        });

    System.out.println(Arrays.toString(list.toArray()));
  }
}
