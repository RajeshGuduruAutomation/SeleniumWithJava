import java.lang.reflect.InvocationTargetException;

class CallByReference {
    public int x = 0;
    private static CallByReference getInstance;
    private CallByReference() {
    this(10);
    }
    CallByReference(int x) {
        this.x = x;
    }
    public void change(int x) {
        CallByReference cbr = new CallByReference(40);
        System.out.println(cbr.x);
        this.x = x + 10;
        System.out.println(x);
        System.out.println(cbr.x);
//        x = 70;
//        System.out.println(x);
    }

    public static CallByReference getInstance() {
        if(CallByReference.getInstance != null || CallByReference.getInstance == null) {
            System.out.println(CallByReference.getInstance);
        }
        if(CallByReference.getInstance == null) {

            getInstance = new CallByReference();
            System.out.println(CallByReference.getInstance);
        }
        return getInstance;
    }


}

class refer {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, CloneNotSupportedException {
        //CallByReference cbr = (CallByReference) Class.forName("CallByReference").getDeclaredConstructor().newInstance();
        CallByReference cbr = CallByReference.getInstance();
        System.out.println(cbr.x);
        cbr.change(50);
        System.out.println(cbr.x);
        cbr.x = 30;
        System.out.println(cbr.x);
        CallByReference cbr1 = CallByReference.getInstance();
        System.out.println(cbr1.x);
        cbr1.change(60);
        System.out.println(cbr.x);
        System.out.println(cbr1.x);
    }
}




