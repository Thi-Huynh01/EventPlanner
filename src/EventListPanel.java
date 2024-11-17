import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class EventListPanel extends JPanel {
    public ArrayList<Event> events;
    public ArrayList<DeadlineDecorator> deadlines;
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
    public ArrayList<JCheckBox> FILTERS;

    public EventListPanel() {

        // Add a deadline and a meeting by default
        Deadline deadL = new Deadline("Deadline : Lab 2   Date: 2024-9-25T12:00", LocalDateTime.of(2024, 9, 25, 15, 0));
        Meeting meet = new Meeting("Meeting : OOP w/Java  Date 2024-9-20T15:00   End time: 2024-9-20T15:50   Location: MCS 339", LocalDateTime.of(2024, 9, 20, 15,0), LocalDateTime.of(2024,9,20, 15, 50,0), "Room 339");

        // Class for opening dialog window
        addEventModal = new AddEventModal();

        // Set background color and dimensions of JFrame
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.pink);

        // Make array list of events
        events = new ArrayList<>();
        deadlines = new ArrayList<>();

        // Create Display panel
        displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(700, (int) (height * .8)));

        // Create Control panel
        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(700, 200));

        // Create Add Event functionality
        addEventButton = new JButton("Add Event");
        addEventButton.setFont(new Font("Tahoma", Font.BOLD, 12));

        // Action listener for addEventButton
        addEventButton.addActionListener(e -> {

            // Show Dialog window for adding an event
            addEventModal.show();

            // addEventModal.getEventType() returns an integer based on the option that the user picked
            int eventType = addEventModal.getEventType();

            // addEventModal.eventMap() takes addEventModal.getEventType() as a parameter and returns a string (e.g "Meeting" or "Deadline")
            String eventName = addEventModal.eventMap() + " : " + addEventModal.getEventName() + "   Date: " + addEventModal.getStartTime();
            String location = addEventModal.returnLocation();

            // Meeting is mapped to 0, deadline and other is mapped to 1 and 2, respectively
            if (eventType == 0) {
                eventName += "   End time: " + addEventModal.getEndTime() + "   Location: " + location;
                addEvent(new Meeting(eventName,addEventModal.getStartTime(), addEventModal.getEndTime(), location));
            }
            else if (eventType == 1 || eventType == 2) {
                //addEvent(new Deadline(eventName,addEventModal.getStartTime()));
                addDeadline(new DeadlineDecorator(new EventL4(eventName, addEventModal.getEndTime())));
            }
        });

        // Finally, add the addEventButton
        controlPanel.add(addEventButton);

        // Create drop-down box
        sortDropDown = new JComboBox(sortOptions);
        sortDropDown.setFont(new Font("Ubuntu", Font.BOLD, 12));
        sortDropDown.addActionListener(e -> {

            // If 'Names (A-Z)' is selected, sort alphabetically
            if (sortDropDown.getSelectedItem().equals(sortOptions[1])) {
                events.sort((e1,e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
            }

            // If 'Names(Z-A)' is selected, sort reversed alphabetically
            if (sortDropDown.getSelectedItem().equals(sortOptions[2])) {
                events.sort((e1,e2) -> e1.getName().compareToIgnoreCase(e2.getName()) * -1);
            }

            // If 'Date' is selected, call overridden method from Event abstract class
            if (sortDropDown.getSelectedItem().equals(sortOptions[3])) {
                Collections.sort(events);
                Collections.reverse(events);
            }
            updateDisplay();

        });

        // Add sortDropDown to controlPanel
        controlPanel.add(sortDropDown);

        // Create ArrayList of Filters. Basically, the following code displays the checkboxes for the filters.
        // Most of this code is from the JComboBox tutorial posted on BlackBoard
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

            // Add checkboxes to FILTERS
            FILTERS.add(checkBox);
        }

        // Add all the checkbox filters to the control panel
        for (JCheckBox checkBox : FILTERS)
            controlPanel.add(checkBox);

        // Add default deadline and meeting
        addEvent(deadL);
        addEvent(meet);

        // Finally, add the control panel and display panel to the JFrame
        add(controlPanel);
        add(displayPanel);
    }

    public boolean isFiltered (Event event) {
// For checkBox in FILTERS
        for (JCheckBox checkBox : FILTERS) {
            if (checkBox.isSelected()) {  // If the user has selected the checkbox...
                if (event.getName().startsWith(checkBox.getText()))  // If the name of the event starts with 'Deadline' or 'Meeting'
                    return true;
            }
        }
        return false;
    }

    public void addEvent(Event event) {
        events.add(event); // Add user-input event to events ArrayList
        updateDisplay(); // Update the display to show the newly added event
    }

    public void addDeadline(DeadlineDecorator deadline) {
        deadlines.add(deadline);
        updateDisplay();
    }

    public void updateDisplay() {
        displayPanel.removeAll();  // Clear display panel

        for (Event event : events) { // Print each event to display panel
            if (!isFiltered (event)) // Print as long as there is no filter (checkbox) selected
                displayPanel.add(new EventPanel(event));
        }

        for (DeadlineDecorator deadline : deadlines) {
            displayPanel.add(new DeadlinePanel(deadline));
        }

        revalidate();
        repaint();
    }

}
