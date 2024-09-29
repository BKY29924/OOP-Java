import javax.swing.JOptionPane;
// 2.2.3
public class HelloNameDialog {
    public static void main(String[] args){
        String result;
        result = JOptionPane.showInputDialog("Please enter your name");
        JOptionPane.showMessageDialog(null, "Hi, " + result + "!");
        System.exit(0);
    }
}