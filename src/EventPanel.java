import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class EventPanel extends JPanel {
    public Event event;
    public AddEventModal modal;
    public JButton completeButton;

    public EventPanel(Event event) {
        setPreferredSize(new Dimension(670, 50));
        setBackground(Color.WHITE);
        this.event = event;

        modal = new AddEventModal();
        String eventType = modal.eventMap();

        System.out.println(modal.eventMap());
        JLabel nameLabel = new JLabel("Event: "+ event.getName());
        nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD));
        add(nameLabel);
        //Deadline deadL = new Deadline("Project", LocalDateTime.of(2024, 9, 25, 15, 0));
        //Meeting meet = new Meeting("OOP w/Java", LocalDateTime.of(2024, 9, 20, 15,0), LocalDateTime.of(2024,9,20, 15, 50,0), "Room 339");

    }

    public void updateUrgency() {

    }
}
