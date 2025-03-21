import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class ViewReservations extends JFrame
{
    private DefaultTableModel model;
    public ViewReservations()
    {
        setTitle("View Reservations");
        setSize(500, 300);
        setLayout(new BorderLayout());
        model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("ID");
        model.addColumn("Guest Name");
        model.addColumn("Room Number");
        loadReservations();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(e -> {dispose();new MainMenu();});
        add(backBtn, BorderLayout.SOUTH);
        setVisible(true);
    }
    private void loadReservations()
    {
        try (Connection conn = DatabaseConnection.getConnection();Statement stmt=conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, guest_name, room_number FROM reservations"))
        {
            while (rs.next())
                model.addRow(new Object[]{rs.getInt("id"), rs.getString("guest_name"), rs.getInt("room_number")});
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error loading reservations: " + ex.getMessage());
        }
    }
}
