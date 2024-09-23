import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;

public class EventListPanel extends JPanel {
    public ArrayList<Event> events;
    public JPanel controlPanel;
    public JPanel displayPanel;
    public JComboBox sortDropDown;
    public JCheckBox filterDisplay;
    public JButton addEventButton;
    private final int width = 800;
    private final int height = 600;
    public JTextField textField;
    final String[] sortOptions = {"Select Filter", "Name", "Date"};
    public AddEventModal addEventModal;

    public EventListPanel() {
        textField = new JTextField();
        addEventModal = new AddEventModal();
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.pink);
        events = new ArrayList<>();
        displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(700, (int) (height * .8)));
        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(700, 200));

        add(controlPanel);
        add(displayPanel);

        addEventButton = new JButton("Add Event");
        addEventButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        addEventButton.addActionListener(e -> {

            addEventModal.show();
            int eventType = addEventModal.getEventType();
            String eventName = addEventModal.eventMap() + ": " + addEventModal.getEventName() + "     Date: " + addEventModal.getStartTime();

            if (eventType == 0) {
                addEvent(new Meeting(eventName,LocalDateTime.now(), LocalDateTime.now(), "Conway"));
            }
            else if (eventType == 1 || eventType == 2) {
                addEvent(new Deadline(eventName,addEventModal.getStartTime()));
            }
        });
        controlPanel.add(addEventButton);
        filterDisplay = new JCheckBox();

        sortDropDown = new JComboBox(sortOptions);
        sortDropDown.setFont(new Font("Ubuntu", Font.BOLD, 12));
        sortDropDown.addActionListener(e -> {
            if (sortDropDown.getSelectedItem().equals(sortOptions[1])) {
                Collections.sort(events);
            }
            if (sortDropDown.getSelectedItem().equals("Date")) {

            }
            updateDisplay();
        });
        controlPanel.add(sortDropDown);

        controlPanel.add(filterDisplay);
    }

    public void addEvent(Event event) {
        events.add(event);
        updateDisplay();
    }

    public void updateDisplay() {
        displayPanel.removeAll();
        for (Event event : events) {
            displayPanel.add(new EventPanel(event));
        }

        revalidate();
        repaint();
    }

}
