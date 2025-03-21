import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class DeleteReservation extends JFrame
{
    private JTextField idField;
    public DeleteReservation()
    {
        setTitle("Delete Reservation");
        setSize(300, 150);
        setLayout(new GridLayout(2, 2));
        add(new JLabel("Reservation ID:"));
        idField = new JTextField();
        add(idField);
        JButton deleteBtn = new JButton("Delete");
        add(deleteBtn);
        JButton backBtn = new JButton("Back");
        add(backBtn);
        deleteBtn.addActionListener(e -> deleteReservation());
        backBtn.addActionListener(e -> {dispose();new MainMenu();});
        setVisible(true);
    }
    private void deleteReservation()
    {
        String idText = idField.getText().trim();
        if (idText.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Reservation ID cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int id;
        try
        {
            id = Integer.parseInt(idText);
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Invalid Reservation ID!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement())
        {
            String checkQuery = "SELECT COUNT(*) FROM reservations WHERE reservation_id = " + id;
            ResultSet rs = stmt.executeQuery(checkQuery);
            rs.next();
            int count = rs.getInt(1);
            if (count == 0)
            {
                JOptionPane.showMessageDialog(this, "Reservation ID does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String deleteQuery = "DELETE FROM reservations WHERE reservation_id = "+id;
            stmt.executeUpdate(deleteQuery);
            JOptionPane.showMessageDialog(this, "Reservation Deleted Successfully!");
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
