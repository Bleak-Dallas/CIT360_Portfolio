
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {

   public static void main (String[] args) {
      
       // HashSet does not retain order
       Set<String> set2 = new HashSet<>();
       // LinkedHasSet will remember the orse
       Set<String> set = new LinkedHashSet<>();
       //Tree set sorts in natural order 1,2,3 A,B,C
       Set<String> set1 = new TreeSet<>();
       
       set1.add("dog");
       set1.add("cat");
       set1.add("wolf");
       set1.add("mouse");
       set1.add("owl");
       set1.add("horse");
       set1.add("pig");
       
       // Adding duplicate does not do anything
       set1.add("horse");
       
       System.out.println(set1);
       
        //Iteration
       for (String element: set1) {
           System.out.println(element);
       }
       
       // Does set contain specific item, use contains() function
       if (set1.contains("rat")) {
           System.out.println("Contains rat"); // does not contain
       }
        if (set1.contains("horse")) {
           System.out.println("Contains horse"); // does contain
       }
               
   }