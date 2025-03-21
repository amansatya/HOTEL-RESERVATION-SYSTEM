import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Statement;
public class UpdateReservation extends JFrame
{
    private JTextField idField, nameField, roomField;
    public UpdateReservation()
    {
        setTitle("Update Reservation");
        setSize(300, 250);
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Reservation ID:"));
        idField = new JTextField();
        add(idField);
        add(new JLabel("Guest Name:"));
        nameField = new JTextField();
        add(nameField);
        add(new JLabel("Room Number:"));
        roomField = new JTextField();
        add(roomField);
        JButton updateBtn = new JButton("Update");
        add(updateBtn);
        JButton backBtn = new JButton("Back");
        add(backBtn);
        updateBtn.addActionListener((ActionEvent e) -> updateReservation());
        backBtn.addActionListener(e -> {dispose();new MainMenu();});
        setVisible(true);
    }
    private void updateReservation()
    {
        int id;
        int roomNumber;
        String guestName = nameField.getText().trim();
        try
        {
            id = Integer.parseInt(idField.getText().trim());
            roomNumber = Integer.parseInt(roomField.getText().trim());
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Invalid ID or Room Number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (guestName.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Guest Name cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try (Connection con=DatabaseConnection.getConnection();Statement stmt = con.createStatement())
        {
            String query = "UPDATE reservations SET guest_name='" + guestName + "', room_number=" + roomNumber + " WHERE id=" + id;
            int rowsUpdated = stmt.executeUpdate(query);
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(this, "Reservation Updated Successfully!");
            else
                JOptionPane.showMessageDialog(this, "Reservation ID not found!", "Update Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}