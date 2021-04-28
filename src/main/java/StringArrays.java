import java.util.ArrayList;
import java.util.Arrays;

public class StringArrays {

    String[] arraysOfStrings = {"Rajesh","Guduru"};

    public static void main(String[] args) {
        StringArrays str = new StringArrays();
        System.out.println("Initial strings :"+str);
        System.out.println("Initial strings :"+str.arraysOfStrings);
        for (String arraysOfString : str.arraysOfStrings) {
            System.out.println("Initial strings :"+arraysOfString);
        }
        str.arraysOfStrings[0] = "rajesh";
        str.arraysOfStrings[1] = "rajesh1";
        //str.arraysOfStrings[2] = "rajesh2";
        System.out.println("Initial strings :"+str);
        System.out.println("Initial strings :"+str.arraysOfStrings);
        for (String arraysOfString : str.arraysOfStrings) {
            System.out.println("Initial strings :"+arraysOfString);
        }

        ArrayList<String> strList =  new ArrayList<>(Arrays.asList(str.arraysOfStrings));

        System.out.println("List of strings :"+strList);
        strList.add("Rajesh2");
        System.out.println("List of strings :"+strList);
    }
}
