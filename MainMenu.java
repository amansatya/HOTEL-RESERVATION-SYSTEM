import javax.swing.*;
import java.awt.*;
public class MainMenu extends JFrame
{
    public MainMenu()
    {
        setTitle("Hotel Reservation System");
        setSize(300, 350);
        setLayout(new GridLayout(5, 1));
        JButton reserveBtn = new JButton("Reserve a Room");
        JButton viewBtn = new JButton("View Reservations");
        JButton updateBtn = new JButton("Update Reservation");
        JButton deleteBtn = new JButton("Delete Reservation");
        JButton getRoomBtn = new JButton("Get Room No");
        add(reserveBtn);
        add(viewBtn);
        add(updateBtn);
        add(deleteBtn);
        add(getRoomBtn);  // ADDING NEW BUTTON
        reserveBtn.addActionListener(e -> new ReserveRoom());
        viewBtn.addActionListener(e -> new ViewReservations());
        updateBtn.addActionListener(e -> new UpdateReservation());
        deleteBtn.addActionListener(e -> new DeleteReservation());
        getRoomBtn.addActionListener(e -> new GetRoomNumber());
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new MainMenu();
    }
}