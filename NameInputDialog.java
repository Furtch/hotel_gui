import javax.swing.*;

public class NameInputDialog {
    public static String showDialog(JFrame parent) {
        String name = JOptionPane.showInputDialog(parent, "Enter Guest Name:");
        if (name != null && !name.trim().isEmpty()) {
            return name;
        } else {
            return "Guest";
        }
    }
}