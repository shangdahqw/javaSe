package bishi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Baidu01 {
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  List<String> wordsByDeleting(String mWord, int numWord, List<String> dictWords) {
    // WRITE YOUR CODE HERE

    boolean[] flagList = new boolean[numWord];

    for (int i = 0; i < numWord; i++) flagList[i] = true;

    for (int i = 0; i < numWord; i++) {

      char[] s = dictWords.get(i).toCharArray();
      String mWordTmp = mWord;

      for (int j = 0; j < s.length; j++) {

        int index = mWordTmp.indexOf(s[j]);
        if (index < 0) {
          flagList[i] = false;
          break;
        } else {
          mWordTmp = mWordTmp.substring(index + 1);
        }
      }
    }

    ArrayList<String> arrayList = new ArrayList<String>();

    for (int k = 0; k < numWord; k++) if (flagList[k]) arrayList.add(dictWords.get(k));

    Collections.sort(
        arrayList,
        new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {

            if (o1.compareTo(o2) >= 0) return 1;
            return -1;
          }
        });

    return arrayList;
  }
  // METHOD SIGNATURE ENDS

  public static void main(String[] args) {

    ArrayList<String> arrayList = new ArrayList<String>();
    arrayList.add("rocs");
    arrayList.add("cksok");
    arrayList.add("roky");
    arrayList.add("raky");

    ArrayList<String> arr =
        (ArrayList<String>) new Baidu01().wordsByDeleting("rocksock", 4, arrayList);

    System.out.println();
  }
}
