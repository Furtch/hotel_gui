import javax.swing.*;
import java.awt.*;

public class RoomWindow {
    private JFrame roomFrame;

    public RoomWindow(int roomNumber, String roomCategory, int price) {
        roomFrame = new JFrame("Room " + String.format("%03d", roomNumber));
        roomFrame.setSize(300, 200);
        roomFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        roomFrame.setLocationRelativeTo(null);

        JLabel label = new JLabel(
                "You are now in " + roomCategory + " " + String.format("%03d", roomNumber)
                + "\nPrice: $" + price, SwingConstants.CENTER);
        JButton closeButton = new JButton("Close");

        closeButton.addActionListener(e -> closeRoomWindow());

        roomFrame.setLayout(new BorderLayout());
        roomFrame.add(label, BorderLayout.CENTER);
        roomFrame.add(closeButton, BorderLayout.SOUTH);
        roomFrame.setVisible(true);
    }

    private void closeRoomWindow() {
        roomFrame.dispose();  
    }
}
