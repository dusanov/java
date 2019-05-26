import java.util.*;
public class MergeNames {
    
    public static String[] uniqueNames(String[] names1, String[] names2) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        Map<String,String> map = new HashMap<String,String>();
        for (String name : names1) map.put(name,name);
        for (String name : names2) map.put(name,name);
        return map.keySet().toArray(new String[map.size()]);
    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}