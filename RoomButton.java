import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomButton extends JButton {
    private int roomNumber;
    private String roomCategory;
    private int price;

    public RoomButton(int roomNumber) {
        super("Room " + String.format("%03d", roomNumber));
        this.roomNumber = roomNumber;

        if (roomNumber >= 7 && roomNumber <= 9) {  // Best Room
            roomCategory = "Best Room";
            price = 500;
        } else if (roomNumber >= 4 && roomNumber <= 6) {  // Better Room
            roomCategory = "Better Room";
            price = 300;
        } else {  // Okay Room
            roomCategory = "Okay Room";
            price = 100;
        }

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RoomWindow(roomNumber, roomCategory, price);
            }
        });
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public int getPrice() {
        return price;
    }
}
