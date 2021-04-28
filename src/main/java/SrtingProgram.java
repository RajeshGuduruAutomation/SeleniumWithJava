import java.util.Arrays;
import java.util.List;

public class SrtingProgram {


    public static void main(String args[]) {
        String str1 = "madams";
        String str2 = new String("Rajesh Guduru MCA Guduru MCA");
        int l = str2.indexOf("Guduru");
        //System.out.println(str2.substring(l,l+"Guduru".length()));

        String[] str4 = str2.split("\\s",0);
        for (String s : str4) {
            System.out.println(s);
        }
        //System.out.println(str2.matches("Rajesh(.*)MCa"));
        char[] charsArr1 = new char[str1.length()];
        for (int j= 0; j< str1.length()-1;j++) {
            charsArr1[j] = str1.charAt(j);
        }
        System.out.println("charsArr1"+charsArr1);
        char[] charsArr = str1.toCharArray();
        System.out.println("charsArr1"+charsArr);
        System.out.println(charsArr.hashCode());
        System.out.println(charsArr1.hashCode());
        for (char c : charsArr1) {
            System.out.print(c);
        }
        for (char c : charsArr) {
            System.out.print(c);
        }
        String newStr= "";
        for (int i = charsArr.length-1;i>=0;i--) {
            newStr = newStr.concat(String.valueOf(charsArr[i]));

        }
        System.out.println("reverse forloop:"+newStr);
        List<String> arrys = Arrays.asList(str1);
        //System.out.println(arrys.get(0));
 StringBuilder dsb = new StringBuilder(str1);
        System.out.println("reverse "+dsb.reverse());
        System.out.println("charsArr.valueof"+String.valueOf(charsArr));
        String str5 =null;
        System.out.println(  str5 == null);

        char[] newschar = {'h','e','l','l','o'};
        String nstr = new String(newschar);
        String nstr1 = nstr.replaceAll("ll","r");
        System.out.println(nstr);System.out.println(nstr1);
        StringBuffer sb;
        sb = new StringBuffer(String.valueOf(newschar));
        System.out.println(sb);
        System.out.println(sb.append(" java"));
        System.out.println(sb.insert(0,"My "));
    }


}
