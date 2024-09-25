import javax.swing.*;
import java.awt.*;

/********************************************
 *** NOT IMPLEMENTED: 'Complete' Checkbox ***
 ********************************************/
public class EventPanel extends JPanel {
    public JCheckBox completeButton;

    public EventPanel(Event event) {

        // Set background and size of event panel
        setPreferredSize(new Dimension(670, 50));
        setBackground(Color.WHITE);

        // Create JCheckBox 'complete' next to each event
        completeButton = new JCheckBox("Complete");
        completeButton.setSize(400,400);
        completeButton.setVisible(true);

        // Prints name of event
        JLabel nameLabel = new JLabel(event.getName());
        nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD));

        // Add nameLabel and completeButton to JFrame
        add(nameLabel);
        add(completeButton);

    }


    public void updateUrgency() {

    }

}
