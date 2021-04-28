package javaLearningPackage;
public class EnumClass {
    public enum Mobiles {
        Samsung(10000), Nokia(1000), Mi, Apple(30000);
        public static final String BROWSER = "chrome";
        public int setPrice;

        Mobiles(){};
        int price;
        Mobiles(int price){
            this.price = price;
        }
        public int getPrice() {
            return price;
        }
        public void setPrice(int price) {
            this.price = price;
        }
    }


}

 class CallEnumClass {
    public static void main(String[] args) {
        for(EnumClass.Mobiles m: EnumClass.Mobiles.values()) {
            System.out.println("Mobile model name "+m.name() +" and with price :"+m.getPrice());
        }
        EnumClass.Mobiles.Mi.price = 2000;
        System.out.println("Mobile model is :"+ EnumClass.Mobiles.Mi.name()+" price is :"+ EnumClass.Mobiles.Mi.getPrice());
        System.out.println("Browser is : "+ EnumClass.Mobiles.BROWSER);
    }
}
