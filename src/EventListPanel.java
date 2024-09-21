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
    final int width = 800;
    final int height = 600;
    public JTextField textField;
    final String[] sortOptions = {"Select Filter", "Name", "Date"};

    public EventListPanel() {
        textField = new JTextField();
        setPreferredSize(new Dimension(800, 800));
        setBackground(Color.pink);
        events = new ArrayList<>();

        displayPanel = new JPanel();
        //displayPanel.setBackground(Color.gray);
        displayPanel.setPreferredSize(new Dimension(700, 400));

        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(700, 200));

        add(controlPanel);
        add(displayPanel);

        addEventButton = new JButton("Add Event");
        addEventButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        addEventButton.addActionListener(e -> {

            addEvent(new Meeting("DEF",LocalDateTime.now(), LocalDateTime.now(), "Conway"));
            addEvent(new Meeting("ABC",LocalDateTime.now(), LocalDateTime.now(), "Batesville"));

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
