import java.util.ArrayList;

public class SandBox {
   
   public static void main(String[] args) {
   
      ArrayList<Integer> numbers = new ArrayList<>(); // declare a new ArrayList of integers
      
      numbers.add(10);  // add items to my ArrayList
      numbers.add(212);
      numbers.add(40);
      numbers.add(16);
      numbers.add(189);
      numbers.add(42);
      
      System.out.println(numbers.get(0)); // print out the first number ArrayList
      System.out.println(); // print a  line
      
      // print out the all the ArrayList using a indexed for loop
      System.out.println("Indexed for loop: ");
      for (int i = 0; i < numbers.size(); i++) {
         System.out.println(numbers.get(i)); // print out the all the ArrayList
      }
      System.out.println(); // print a line
      
       //Removing items from an ArrayList
      // first way is to remove using the size method
      System.out.println("Remove the last and first items from the ArrayList");
      numbers.remove(numbers.size() - 1); //removes the last item from the list
      numbers.remove(0); // removes the first item from the list
      
      //Iteration using a advance for loop
      System.out.println("Advanced for loop: ");
      for (Integer value: numbers) {
      	System.out.println(value);
      }
   }
}