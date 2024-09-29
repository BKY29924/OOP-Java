import javax.swing.JOptionPane;
//2.2.4
public class ShowTwoNumbers {
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "You're just entered: ";
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";
        strNum2 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;
        JOptionPane.showMessageDialog(null, strNotification, "Show two number", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}