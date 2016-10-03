import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeExample {

   public static void main (String[] args) {
      
       // NO garunteed order when printed
       HashMap<Integer, String> hashMap = new HashMap<>(); 
       // Does stay in order as entered
       LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
       // will keep in ordered list such as 1,2,3 or A,B,C
       TreeMap<Integer, String> treeMap = new TreeMap<>();
       
       String h = "HashMap";
       String l = "LinkedHashMap";
       String t = "TreeMap";
       
       testMap(h, hashMap);
       testMap(l, linkedHashMap);
       testMap(t, treeMap);
   }
   
   public static void testMap(String v, Map<Integer, String> map) {
       // Add to the mapsvalue
       map.put(9, "fox");
       map.put(7, "deer");
       map.put(1, "rabbit");
       map.put(3, "wolf");
       map.put(6, "coyote");
       map.put(5, "mouse");
       
       System.out.println(v); // Print out type of Map
       // Print the key and values of the maps
       for (Integer key: map.keySet()) {
           String value = map.get(key);

           System.out.println(key + ": " + value);
       }
        System.out.println();
   }

}