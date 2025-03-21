import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class GetRoomNumber extends JFrame {
    private JTextField idField, nameField;
    private JLabel resultLabel;
    public GetRoomNumber() {
        setTitle("Get Room Number");
        setSize(350, 250);
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Guest ID:"));
        idField = new JTextField();
        add(idField);
        add(new JLabel("Guest Name:"));
        nameField = new JTextField();
        add(nameField);
        JButton getRoomBtn = new JButton("Get Room No");
        add(getRoomBtn);
        resultLabel = new JLabel("");
        add(resultLabel);
        JButton backBtn = new JButton("Back");
        add(backBtn);
        getRoomBtn.addActionListener(e -> getRoomNumber());
        backBtn.addActionListener(e -> {dispose();new MainMenu();});
        setVisible(true);
    }
    private void getRoomNumber()
    {
        String guestID = idField.getText().trim();
        String guestName = nameField.getText().trim();
        if (guestID.isEmpty() || guestName.isEmpty())
        {
            resultLabel.setText("Please enter ID and Name!");
            return;
        }
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement())
        {
            String query="SELECT room_number FROM reservations WHERE guest_id="+guestID+" AND guest_name='"+guestName+"'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next())
                resultLabel.setText("Room No: " + rs.getInt("room_number"));
            else
                resultLabel.setText("No Reservation Found");

        }
        catch (Exception ex)
        {
            resultLabel.setText("Error: " + ex.getMessage());
        }
    }
}
