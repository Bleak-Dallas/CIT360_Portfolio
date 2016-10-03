import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
   
   public static void main (String[] args) {
      
      /* ArrayLists manage array internally
       * [0][1][2][3][4]....
       * Use this list if you only want to add or 
       * remove items from the end of the list
       */
      ArrayList<String> arrayList = new ArrayList<>();
      
      /* LinkedLists consists of elements where each elements
       * has a reference to the previous and next element.
       * [0]-> <-[1]-> <-[2]->....
       * Use if you want to add or remove items from anyplace 
       * in the list but the end of the list.
       */
      LinkedList<Integer> linkedList = new LinkedList<>();
   
      /* 
       * When adding items to an ArrayList it takes longer to add them to the begining of the list, 
       * and shorter to add them to the end of the list comparetivley to the LinkedList. The LinkedList
       * takes about the same time to add items to the end or the beggining of the list. 
       */
      
      arrayList.add("Hello");
      arrayList.add("Good Bye");
      arrayList.add("Merci");
      arrayList.add("Hola");
      
      linkedList.add(5);
      linkedList.add(42);
      linkedList.add(120);
      linkedList.add(66);
      
      doStuffArrayList("ArrayList", arrayList);
      doStuffLinkedList("LinkedList", linkedList);
   }

    private static void doStuffArrayList(String vaule, ArrayList<String> arrayList0) {
        
       for (String list1 : arrayList0) {
           System.out.println(list1);
       }
       System.out.println();
    }

    private static void doStuffLinkedList(String linkedList, LinkedList<Integer> linkedList0) {
        for (Integer list2 : linkedList0) {
           System.out.println(list2);
        }
    }
}
