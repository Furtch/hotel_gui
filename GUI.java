import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFrame frame;
    private ReservationManager manager;
    private String guestName;
    private double roomPrice;

    public GUI() {
        manager = new ReservationManager();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Hotel Reservation");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new BackgroundPanel());
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel prompt = new JLabel("Would you like to make a reservation?");
        prompt.setFont(new Font("Times New Roman", Font.BOLD, 16));
        prompt.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        frame.add(prompt, gbc);

        JButton yesButton = new JButton("Yes");
        yesButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        yesButton.setForeground(Color.black);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        frame.add(yesButton, gbc);
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                showDashboard();
            }
        });

        JButton noButton = new JButton("No");
        noButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        noButton.setForeground(Color.black);
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(noButton, gbc);
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    private void showDashboard() {
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel = new JLabel("Enter guest name:");
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nameLabel.setForeground(Color.black);
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(nameLabel, gbc);

        JTextField nameField = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(nameField, gbc);

        JButton proceedButton = new JButton("Proceed");
        proceedButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        proceedButton.setForeground(Color.black);
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(proceedButton, gbc);
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                guestName = nameField.getText();
                if (guestName.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter your name.");
                } else {
                    chooseRoom();
                }
            }
        });

        frame.revalidate();
        frame.repaint();
    }

    private void chooseRoom() {
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel roomLabel = new JLabel("Choose your room:");
        roomLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        roomLabel.setForeground(Color.black);
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(roomLabel, gbc);

        JRadioButton standard = new JRadioButton("Standard Room ($100)");
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(standard, gbc);

        JRadioButton deluxe = new JRadioButton("Deluxe Suite ($200)");
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(deluxe, gbc);

        JRadioButton presidential = new JRadioButton("Presidential Suite ($500)");
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(presidential, gbc);

        ButtonGroup roomGroup = new ButtonGroup();
        roomGroup.add(standard);
        roomGroup.add(deluxe);
        roomGroup.add(presidential);

        JButton confirmButton = new JButton("Confirm Room");
        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(confirmButton, gbc);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (standard.isSelected()) roomPrice = 100;
                else if (deluxe.isSelected()) roomPrice = 200;
                else if (presidential.isSelected()) roomPrice = 500;
                else {
                    JOptionPane.showMessageDialog(frame, "Please select a room.");
                    return;
                }
                addExtras();
            }
        });

        frame.revalidate();
        frame.repaint();
    }

    private void addExtras() {
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nightsLabel = new JLabel("Enter number of nights:");
        nightsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nightsLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(nightsLabel, gbc);

        JTextField nightsField = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(nightsField, gbc);

        JButton finalizeButton = new JButton("Finalize Reservation");
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(finalizeButton, gbc);
        finalizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    int nights = Integer.parseInt(nightsField.getText());
                    HotelReservation reservation = new HotelReservation(guestName, "Room", nights, roomPrice, 0);
                    manager.addReservation(reservation);
                    JOptionPane.showMessageDialog(frame, "Reservation confirmed for " + guestName + ". Total cost: $" + reservation.calculateTotalCost());
                    askForAnotherReservation();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number of nights.");
                }
            }
        });

        frame.revalidate();
        frame.repaint();
    }

    private void askForAnotherReservation() {
        int response = JOptionPane.showConfirmDialog(frame, "Would you like to make another reservation?", "New Reservation", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            showDashboard();
        } else {
            manager.showAllReservations();
            frame.dispose();
        }
    }

    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel() {
            ImageIcon icon = new ImageIcon("C:\\Users\\Acer\\Downloads\\hotel-background.jpg"); // Use relative path
            backgroundImage = icon.getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}