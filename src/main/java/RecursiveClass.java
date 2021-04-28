public class RecursiveClass {
    public static int fact(int number) {
        int f = 1;
        if (number > 0) {
            System.out.println(number+" "+ f);
            f = fact(number - 1) * number;
            System.out.println( f);
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
    }
}
