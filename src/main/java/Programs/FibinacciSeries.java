package Programs;

public class FibinacciSeries {
    static int t1=0, t2=1;
    static int t3;
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

    private static int fibonacci(int n) {
        System.out.print(t1+""+t2);
        if (n<=1)
            return n;
        else{
            t3 = t1 + t2;
            t1 = t2;
            t2 = t3;


            int n1=  fibonacci(n-1) ;
            return n1;
        }

    }
}
