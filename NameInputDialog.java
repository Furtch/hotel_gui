import javax.swing.*;

public class NameInputDialog {
    public static String showDialog(JFrame parent) {
        String name = JOptionPane.showInputDialog(parent, "Enter Guest Name:");
        return name != null && !name.trim().isEmpty() ? name : "Guest";
    }
}
