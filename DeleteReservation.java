import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
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
        int id = Integer.parseInt(idField.getText());
        try (Connection conn=DatabaseConnection.getConnection();Statement stmt=conn.createStatement())
        {
            String query = "DELETE FROM reservations WHERE id=" + id;
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Reservation Deleted Successfully!");
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
