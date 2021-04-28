import javaLearningPackage.EnumClass;

import javax.swing.*;

public class SwitchClass {


    public static void main(String[] args) {
        int number = 530;
        char aChar = '-';
        String string = "Daanvi";

        switch (aChar) {
            case '+':
                System.out.println("value is 510 + 510 = "+(510+510));
                break;
            case '-':
                System.out.println("value is 520 - 520 = "+(520-520));
                break;
            case '*':
                System.out.println("value is 530");
                break;
            default:
                System.out.println("value is Daanvi");
        }

        String s1,status;
        char code;
        s1 = JOptionPane.showInputDialog("Please enter Gender: M/F");
        code = s1.charAt(0);
        System.out.println(code);
        switch (code) {
            case 'M':
                JOptionPane.showMessageDialog(null,"Gender is Male","",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Male");
                break;
            case 'F':
                JOptionPane.showMessageDialog(null,"Gender is FeMale","",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Female");
                break;
             default:
                    JOptionPane.showMessageDialog(null,"Gender default","",JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Default");
        }

        EnumClass.Mobiles[] mobiles = EnumClass.Mobiles.values();
        for (EnumClass.Mobiles mobile : mobiles) {
            if(mobile.getPrice() == 0) {
                mobile.setPrice(2000);
            }
            System.out.println("Mobile name is: "+mobile.name() +" and price is : "+mobile.getPrice());

        }
    }
}
