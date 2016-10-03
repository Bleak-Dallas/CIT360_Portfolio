/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


/**
 *
 * @author VHASLCBleakD 
 */
public class SetExample {

public static final String YELLOW = "\u001B[33m";
//Reset code
public static final String RESET = "\u001B[0m";

   public static void main (String[] args) {
      
       // HashSet does not retain order
       Set<String> set2 = new HashSet<>();
       // LinkedHasSet will remember the order
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
       
       set2.add("Bilbo");
       set2.add("Frodo");
       set2.add("Gandalf");
       set2.add("Aragorn");
       set2.add("Legolas");
       set2.add("Arwen");
       set2.add("Gimli");
       
       
       // Print list
       System.out.println(YELLOW + "Original set1:" + RESET);
       System.out.println(set1);
       
       // Adding duplicate does not do anything
       set1.add("horse");
       
       // Remove items
       set1.remove("owl");
       
        //Iteration
       System.out.println(YELLOW + "\nAfter adding horse and removing owl:" + RESET);
       for (String element: set1) {
           System.out.println(element);
       }
       
        // Use iterator to display contents of al
        System.out.print(YELLOW + "\nOriginal contents of set2: " + RESET);
        Iterator itr = set2.iterator();
      
        while(itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + ", ");
        }
       
       // Does set contain specific item, use contains() function
        System.out.println(YELLOW + "\n\nThis shows the use of the contains keyword;" + RESET);
       if (set1.contains("rat")) {
           System.out.println("Contains rat");
       }
       
        if (set1.contains("horse")) {
           System.out.println("Contains horse");
       }
               
   }
   

}

