// Exercise 6.1
package hust.soict.dsai.lab01;;
import javax.swing.JOptionPane;

public class ChoosingOption {
	public static void main(String[] args) {
		
		// Tập lựa chọn
		String[] options = {"I do", "I don't"};
		
//		int option = JOptionPane.showConfirmDialog(null,
//				"Do you want to change to the first class ticket?");
//		
//		JOptionPane.showMessageDialog(null,
//				"You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
		int option = JOptionPane.showOptionDialog(null,
                "Do you want to change to the first class ticket?",
                "Custom Confirm Dialog Example",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
		
//		JOptionPane.showMessageDialog(null,
//				"You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
		JOptionPane.showMessageDialog(null,
				"You've chosen: " + options[option]);
		
		System.exit(0);
	}
}