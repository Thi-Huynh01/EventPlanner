import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Predicate;


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
    final String[] sortOptions = {"Select Display Order", "Name (A-Z)", "Name (Z-A)","Date"};
    final String[] filters = {"Meeting", "Deadline", "Remove Completed" };
    public AddEventModal addEventModal;
    ArrayList<JCheckBox> FILTERS;

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


        addEventButton = new JButton("Add Event");
        addEventButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        addEventButton.addActionListener(e -> {

            addEventModal.show();
            int eventType = addEventModal.getEventType();
            String eventName = addEventModal.eventMap() + " : " + addEventModal.getEventName() + "   Date: " + addEventModal.getStartTime();
            String location = addEventModal.returnLocation();

            if (eventType == 0) {
                eventName += "   End time: " + addEventModal.getEndTime() + "   Location: " + location;
                addEvent(new Meeting(eventName,addEventModal.getStartTime(), addEventModal.getEndTime(), location));
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
                events.sort((e1,e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
            }
            if (sortDropDown.getSelectedItem().equals(sortOptions[2])) {
                events.sort((e1,e2) -> e1.getName().compareToIgnoreCase(e2.getName()) * -1);
            }
            if (sortDropDown.getSelectedItem().equals(sortOptions[3])) {
                Collections.sort(events);
            }
            updateDisplay();

        });

        controlPanel.add(sortDropDown);
        FILTERS = new ArrayList<>();
        for (String filter : filters) {
            JCheckBox checkBox = new JCheckBox(filter);
            checkBox.setFont(new Font("Ubuntu", Font.BOLD, 12));
            checkBox.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    updateDisplay();
                }
            });
            FILTERS.add(checkBox);
        }

        for (JCheckBox checkBox : FILTERS)
            controlPanel.add(checkBox);

        add(controlPanel);
        add(displayPanel);
    }

    public boolean isFiltered (Event event) {

        for (JCheckBox checkBox : FILTERS) {
            if (checkBox.isSelected()) {
                if (event.getName().startsWith(checkBox.getText()))
                    return true;
            }
        }
        return false;
    }

    public void addEvent(Event event) {
        events.add(event);
        updateDisplay();
    }

    public void updateDisplay() {
        displayPanel.removeAll();

        for (Event event : events) {
            if (!isFiltered (event))
                displayPanel.add(new EventPanel(event));
        }

        revalidate();
        repaint();
    }

}
