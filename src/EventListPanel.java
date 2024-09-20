import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class EventListPanel extends JPanel {
    public ArrayList<Event> events;
    public JPanel controlPanel;
    public JPanel displayPanel;
    public JComboBox sortDropDown;
    public JCheckBox filterDisplay;
    public JButton addEventButton;

    public EventListPanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.pink);
        events = new ArrayList<>();

        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(700, 500));
        add(controlPanel);

        addEventButton = new JButton("Add Event");
        addEventButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        addEventButton.addActionListener(e -> {
            //addEvent(new Meeting("CS CLUB",LocalDateTime.now(), LocalDateTime.now(), "Batesville"));
        });

        controlPanel.add(addEventButton);
        displayPanel = new JPanel();

        //sortDropDown = new JComboBox();
        //filterDisplay = new JCheckBox();
    }

    public void addEvent(Event event) {
        events.add(event);

    }

}
