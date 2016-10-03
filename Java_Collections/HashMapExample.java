import java.util.HashMap;
import java.util.Map;


public class HashMapExample {
   
    public static void main(String[] args) {
      // Create a new HashMap
      HashMap<Integer, String> map = new HashMap<>();
      
      // Add items to the HashMap
      // REMEBER!! a HashMap may not maintain this order when iterated with a loop
      map.put(5,   "Five");
      map.put(10,  "Ten");
      map.put(15,  "Fifteen");
      map.put(8,   "Eight");
      map.put(42,  "Forty Two");
      map.put(100, "One Hundred");
      map.put(4,   "Four");
      map.put(2,   "Two");
      map.put(39,  "Thirty Nine");
      
      // Retrieve an item from the HashMap
      String text = map.get(42);
      
      // Print the HashMap from the item
      System.out.println(text);
      
      // Iterate through the map with a for each loop and
      // using the Map.Entry and the map.entrySet()
      for (Map.Entry<Integer, String> entry: map.entrySet()) {
         int key = entry.getKey();        // retrives the key in the HashMap
         String value = entry.getValue(); // retrieves the value in the Hashmap
         
         // Print the ket and value from the HashMap
         System.out.println(key + ": " + value); 
      }
   }
}
