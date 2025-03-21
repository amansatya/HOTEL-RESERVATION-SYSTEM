import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class ViewReservations extends JFrame
{
    private JTable reservationsTable;
    private DefaultTableModel tableModel;
    public ViewReservations()
    {
        setTitle("View Reservations");
        setSize(600, 400);
        setLayout(new BorderLayout());
        String[] columns = {"ID", "Guest Name", "Room No", "Contact No", "Date"};
        tableModel = new DefaultTableModel(columns, 0);
        reservationsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(reservationsTable);
        add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        JButton backBtn = new JButton("Back");
        buttonPanel.add(backBtn);
        add(buttonPanel, BorderLayout.SOUTH);
        backBtn.addActionListener(e -> {dispose();new MainMenu();});
        loadReservations();
        setVisible(true);
    }
    private void loadReservations()
    {
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement())
        {
            String query = "SELECT * FROM reservations ORDER BY reservation_id DESC";
            ResultSet rs = stmt.executeQuery(query);
            tableModel.setRowCount(0);
            while (rs.next())
            {
                int id = rs.getInt("reservation_id");
                String guestName = rs.getString("guest_name");
                int roomNumber = rs.getInt("room_number");
                String contactNumber = rs.getString("contact_number");
                String reservationDate = rs.getString("reservation_date");

                tableModel.addRow(new Object[]{id, guestName, roomNumber, contactNumber, reservationDate});
            }
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
