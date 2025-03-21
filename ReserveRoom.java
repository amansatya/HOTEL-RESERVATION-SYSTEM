import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Statement;
public class ReserveRoom extends JFrame {
    private JTextField nameField, roomField, phoneField;
    public ReserveRoom()
    {
        setTitle("Reserve Room");
        setSize(300, 250);
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Guest Name:"));
        nameField = new JTextField();
        add(nameField);
        add(new JLabel("Phone Number:"));
        phoneField = new JTextField();
        add(phoneField);
        add(new JLabel("Room Number:"));
        roomField = new JTextField();
        add(roomField);
        JButton reserveBtn = new JButton("Reserve");
        add(reserveBtn);
        JButton backBtn = new JButton("Back");
        add(backBtn);
        reserveBtn.addActionListener((ActionEvent e) -> reserveRoom());
        backBtn.addActionListener(e -> {dispose();new MainMenu();});
        setVisible(true);
    }
    private void reserveRoom()
    {
        String guestName = nameField.getText().trim();
        String phoneNumber = phoneField.getText().trim();
        int roomNumber;
        try
        {
            roomNumber = Integer.parseInt(roomField.getText().trim());
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Invalid Room Number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (guestName.isEmpty() || phoneNumber.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Guest Name and Phone Number cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement())
        {
            String query = "INSERT INTO reservations (guest_name, contact_number, room_number) " + "VALUES ('" + guestName + "', '" + phoneNumber + "', " + roomNumber + ")";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Room Reserved Successfully!");
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
