import java.util.LinkedHashMap;
import java.util.Map;

public class TestMyHashMap {
    public static void main(String[] args) {
        // Create a map
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Lewis", 29);
        map.put("Cook", 29);
        map.put("Anderson", 31);
        map.put("Smith", 30);
        map.put("Smith", 65); // Add Smith with age 65 to map

        // Print the entries in map using square brackets
        System.out.print("Entries in map: [");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print("[" + entry.getKey() + ", " + entry.getValue() + "]");
        }
        System.out.println("]");

        // Print the age for Lewis
        System.out.println("The age for Lewis is " + map.get("Lewis"));

        // Check if "Smith" is in the map
        System.out.println("Is Smith in the map? " + map.containsKey("Smith"));

        // Check if age 33 is in the map
        System.out.println("Is age 33 in the map? " + map.containsValue(33));

        // Remove Smith from the map and print the updated entries
        map.remove("Smith");
        System.out.print("Entries in map: [");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print("[" + entry.getKey() + ", " + entry.getValue() + "]");
        }
        System.out.println("]");

        // Clear the map and print that it's empty
        map.clear();
        System.out.println("Entries in map: []");
    }
}
