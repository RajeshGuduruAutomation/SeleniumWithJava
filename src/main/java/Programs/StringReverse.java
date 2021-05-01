package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StringReverse {

    public static void main(String[] args) {
        String str = "JavaStringReverse";

        //Method 1
        StringBuilder sb = new StringBuilder(str);
        System.out.println("reverse String of "+str+" is : "+sb.reverse());

        //Method 2
        StringBuilder sb1 = new StringBuilder();
        char[] strArray = str.toCharArray();
        for (int i = strArray.length-1; i >=0 ; i--) {
            sb1.append(strArray[i]);
        }
        System.out.println("reverse String of "+str+" is : "+sb1.toString());

        //Method 3
        StringBuilder sb2 = new StringBuilder();
        for (int i = str.length()-1; i >=0 ; i--) {
            sb2.append(str.charAt(i));
        }
        System.out.println("reverse String of "+str+" is : "+sb2.toString());
           }
}
