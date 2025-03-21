import javax.swing.*;
import java.awt.*;
public class MainMenu extends JFrame
{
    public MainMenu()
    {
        setTitle("Hotel Reservation System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        JButton reserveBtn = new JButton("Reserve a Room");
        JButton viewBtn = new JButton("View Reservations");
        JButton updateBtn = new JButton("Update Reservation");
        JButton deleteBtn = new JButton("Delete Reservation");
        JButton getRoomBtn = new JButton("Get Room No");
        JButton exitBtn = new JButton("Exit");
        Dimension buttonSize = new Dimension(200, 40);
        reserveBtn.setPreferredSize(buttonSize);
        viewBtn.setPreferredSize(buttonSize);
        updateBtn.setPreferredSize(buttonSize);
        deleteBtn.setPreferredSize(buttonSize);
        getRoomBtn.setPreferredSize(buttonSize);
        exitBtn.setPreferredSize(buttonSize);
        reserveBtn.addActionListener(e -> {dispose();new ReserveRoom();});
        viewBtn.addActionListener(e -> {dispose();new ViewReservations();});
        updateBtn.addActionListener(e -> {dispose();new UpdateReservation();});
        deleteBtn.addActionListener(e -> {dispose();new DeleteReservation();});
        getRoomBtn.addActionListener(e -> {dispose();new GetRoomNumber();});
        exitBtn.addActionListener(e -> System.exit(0));
        gbc.gridy = 0;
        add(reserveBtn, gbc);
        gbc.gridy = 1;
        add(viewBtn, gbc);
        gbc.gridy = 2;
        add(updateBtn, gbc);
        gbc.gridy = 3;
        add(deleteBtn, gbc);
        gbc.gridy = 4;
        add(getRoomBtn, gbc);
        gbc.gridy = 5;
        add(exitBtn, gbc);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new MainMenu();
    }
}
