import java.util.Arrays;
import java.util.Random;

public class ArrayAndListImpl extends ArrayAndList {
    static int[] arrss = new int[5];

    ArrayAndListImpl() {
        super();
    }
    public static void test() {

        arrss[4] = 4;

        System.out.println(arrss);
    }

    public static void main(String[] args) {
        test();
        for (int i = 0; i < arrss.length; i++) {
            arrss[i] = new Random().nextInt();
            System.out.println(arrss[i]);
        }
        Arrays.sort(arrss);

        System.out.println(" sorted arrss"+arrss);
        for (int i = 0; i < arrss.length; i++) {

            System.out.println(arrss[i]);
        }
    }


}
