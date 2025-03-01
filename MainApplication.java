// Part 4: MainApplication.java (Main GUI with 3x3 grid of buttons)
import javax.swing.*;
import java.awt.*;

public class MainApplication {
    private JFrame mainFrame;
    private JPanel gridPanel;
    private String userName;

    public MainApplication(String userName) {
        this.userName = userName;
        mainFrame = new JFrame("Room Selector");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 400);
        mainFrame.setLocationRelativeTo(null);

        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3, 3, 10, 10));

        for (int i = 9; i >= 1; i--) {
            RoomButton button = new RoomButton(i); 
            gridPanel.add(button);
        }

        JLabel welcomeLabel = new JLabel("Welcome, " + userName, SwingConstants.CENTER);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(welcomeLabel, BorderLayout.NORTH);
        mainFrame.add(gridPanel, BorderLayout.CENTER);

        mainFrame.setVisible(true);
    }
}
