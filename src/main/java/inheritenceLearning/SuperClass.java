package inheritenceLearning;

public class SuperClass {
    int age;
    String name;
    String gender;
    double height;
    private String color;
    public static String college;
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public SuperClass(int age, String name, String gender, double height, String color, String college) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.color = color;
        Subclass.college = college;
    }

    public void display() {
        System.out.println("Superclas Name is :"+name);
        System.out.println("Superclas Age is :"+age);
        System.out.println("Superclas Gender is :"+gender);
        System.out.println("Superclas Height is :"+height);
        System.out.println("Superclas color is :"+color);
        System.out.println("Superclas College is :"+college);
    }
}
class Subclass extends SuperClass {
    int marks;
    int grade;
    String status;
    String color;
    Subclass(int marks, int grade, String status, String color) {
        super(18, "Rajesh", "Male", 5.10, "Fair", "ABC College");
       this.marks = marks;
       this.grade = grade;
       this.status = status;
       this.color = color;
    }
    @Override
    public void display() {
        System.out.println("Marks : "+marks);
        System.out.println("Grade : "+grade);
        System.out.println("Status : "+status);
        System.out.println("Coluor subclass: "+this.color);
        System.out.println("Coluor superclass: "+super.getColor());
        System.out.println("College : "+college);
    }
    public void details() {
        System.out.println("Details method in subclass : ");
        /*System.out.println("Grade : "+grade);
        System.out.println("Status : "+status);
        System.out.println("Coluor subclass: "+this.color);
        System.out.println("Coluor superclass: "+super.getColor());
        System.out.println("College : "+college);*/


    }

    public static void main(String[] args) {
        Subclass sc = new Subclass(80,1,"Pass", "Fair1");
        SuperClass superc = new SuperClass(1, "RajeshG", "Male", 5.11, "FairS", "ABC CollegeS");
        sc.display();
        superc.display();
        sc.details();
        sc.name = "Rajesh Guduru";
        sc.age = 33;
        sc.color="AverageSubClass";
        college = "ACB college of tech";
        sc.setColor("AverageSuperClass");
        sc.display();
        sc.details();
        superc.display();
    }
}
