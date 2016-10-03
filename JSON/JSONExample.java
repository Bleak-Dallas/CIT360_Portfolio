package jsonexample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author VHASLCBleakD
 */

public class JSONExample {

    public static void main(String[] args) {
        
        Scanner  input = new Scanner(System.in); // get info from the keyboard
        
        System.out.println("Enter employee name: ");
        String name  = input.nextLine();
        
        // create a new JSON object
        JSONObject root = new JSONObject();
        
        // put the name name-value pair
        root.put("name", name);
        
        //create a JSON array
        JSONArray certifications = new JSONArray();
        
        while(true){
            
            // get the certification name
            System.out.print("Enter employee certification: ");
            String cert = input.nextLine();

            // check to se if user hit Enter
            if (cert.length() == 0) {
                break;
            }
            
            // get the state name
            System.out.print("Enter certification state: ");
            String state = input.nextLine();

            // create a JSON object and array and store a class object in it
            JSONObject unitObject1 = new JSONObject();
            unitObject1.put("state", state);
            unitObject1.put("certifications", cert);
            
            // add the course ot the array
            certifications.add(unitObject1);
        }
        
        // add the array to the root object
        root.put("certifications", certifications);
        
        System.out.println(root.toJSONString());
        
        // create a file and write the JSON structure to it
        File file = new File("EmployeeInformation.txt");
        
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.print(root.toJSONString());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }
        
        System.out.println("File created successfully\n\n Hit Return to continue to display");
        System.out.println();
        
        try {
            Scanner jsonInput = new Scanner(file);
            StringBuilder jsonIn = new StringBuilder();
           while (jsonInput.hasNextLine()) {
               jsonIn.append(jsonInput.nextLine());
           }
            System.out.println(jsonIn.toString());
            input.nextLine();
            
            JSONParser parser = new JSONParser();
            
            JSONObject objRoot = (JSONObject) parser.parse(jsonIn.toString());
            
            System.out.printf("Employee name is %s\n", objRoot.get("name").toString());
            
            JSONArray certsIn = (JSONArray) objRoot.get("certifications");
            
            for (int i = 0; i < certifications.size(); i++) {
                JSONObject certIn = (JSONObject) certsIn.get(i);
                String stateIn = (String) certIn.get("state");
                String nameIn = (String) certIn.get("certifications");
                System.out.printf("Certifications: %s - State: %s \n", nameIn, stateIn);
            }
        } catch (FileNotFoundException | ParseException ex) {
            System.out.println(ex.toString());
        }
    }
}
