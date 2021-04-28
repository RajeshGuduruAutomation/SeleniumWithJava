import java.lang.reflect.InvocationTargetException;

public class CallByReference {
    int x;
    public CallByReference() {

    }
    CallByReference(int x) {
        this.x = x;
    }
    public void change(int x) {
        CallByReference cbr = new CallByReference(40);
        System.out.println(cbr.x);
        cbr.x = x + 10;
        System.out.println(x);
        System.out.println(cbr.x);
//        x = 70;
//        System.out.println(x);
    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, CloneNotSupportedException {
        CallByReference cbr = (CallByReference) Class.forName("CallByReference").getDeclaredConstructor().newInstance();
        System.out.println(cbr.x);
        cbr.change(50);
        System.out.println(cbr.x);
        CallByReference cbr1 = new CallByReference();
        System.out.println(cbr1.x);
        cbr1.change(60);
        System.out.println(cbr.x);
        System.out.println(cbr1.x);
    }
}





