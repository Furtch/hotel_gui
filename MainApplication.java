import javax.swing.*;
import java.awt.*;

public class MainApplication {
    private JFrame mainFrame;
    private JPanel gridPanel;
    private String userName;
    private JPanel leftJPanel, rightJPanel;
    private int currentFloor = 1; 
    private final int totalFloor = 4;

    public MainApplication(String userName) {
        this.userName = userName;
        mainFrame = new JFrame("Room Selector");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);
        mainFrame.setLocationRelativeTo(null);

        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3, 3, 20, 20));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        leftJPanel = new JPanel();
        rightJPanel = new JPanel();

        JButton leftButton = ArrowControls.createArrowsButton("left", e -> scrollLeft());
        JButton rightButton = ArrowControls.createArrowsButton("right", e -> scrollRight());

        leftJPanel.add(leftButton);
        rightJPanel.add(rightButton);

        leftJPanel.setLayout(new GridBagLayout());
        rightJPanel.setLayout(new GridBagLayout());

        JLabel welcomeLabel = new JLabel("Welcome, " + userName, SwingConstants.CENTER);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(welcomeLabel, BorderLayout.NORTH);
        mainFrame.add(gridPanel, BorderLayout.CENTER);
        mainFrame.add(leftJPanel, BorderLayout.WEST);
        mainFrame.add(rightJPanel, BorderLayout.EAST);

        mainFrame.setVisible(true);

        
        loadedRooms(currentFloor);
    }

    
    private void scrollLeft() {
        if (currentFloor > 1) { 
            currentFloor--;
            loadedRooms(currentFloor);
        }
    }

    private void scrollRight() {
        if (currentFloor < totalFloor) {
            currentFloor++;
            loadedRooms(currentFloor);
            System.out.println("Moved to Page " + currentFloor);
        } else {
            System.out.println("Already on last page!");
        }
    }

    private void loadedRooms(int pages) {
        gridPanel.removeAll();

        int startRoom = (pages - 1) * 9 + 1;
        int endRoom = Math.min(pages * 9, 36);

        for (int i = endRoom; i >= startRoom; i--) {
            RoomButton button = new RoomButton(i);
            gridPanel.add(button);
        }

        gridPanel.revalidate();
        gridPanel.repaint();
    }
}
