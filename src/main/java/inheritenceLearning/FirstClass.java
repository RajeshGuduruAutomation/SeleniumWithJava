package inheritenceLearning;

public class FirstClass {

    static String name;
    int age;
    static {
        name = "Rajesh";
        System.out.println("static block 1. Name is :"+name);
    }
    {
        age = 30;
        System.out.println("block code, Age is :"+age);
    }
    static {
        name = "Rajesh1";
        System.out.println("static block 2 . Name is :"+name);
    }
    void m1() {
        System.out.println("FirstClass M1");
    }
}
class SecondClass extends FirstClass{
    public  SecondClass() {

        System.out.println("SecondClass constructor");
    }
    void m1() {
        System.out.println("SecondClass M1");
    }
    void m2() {
        System.out.println("SecondClass M2");
    }
}

class ThirdClass extends SecondClass{
    public  ThirdClass() {

        System.out.println("ThirdClass constructor");
    }
    void m1() {
        System.out.println("ThirdClass M1");
    }
//    void m2() {
//        System.out.println("ThirdClass M2");
//    }

    public static void main(String[] args) {
        SecondClass t = new ThirdClass();
        if (t instanceof ThirdClass) {
            System.out.println("t instanceof ThirdClass");
        }
        if (t instanceof FirstClass) {
            System.out.println("t instanceof FirstClass");
        }
        if (t instanceof SecondClass) {
            System.out.println("t instanceof SecondClass");
        }
        t.m2();
    }
}
