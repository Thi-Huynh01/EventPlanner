import javax.swing.*;
import java.awt.*;

public class EventPanel extends JPanel {
    public Event event;
    public JCheckBox completeButton;

    public EventPanel(Event event) {
        setPreferredSize(new Dimension(670, 50));
        setBackground(Color.WHITE);
        this.event = event;
        completeButton = new JCheckBox("Complete");
        completeButton.setSize(400,400);
        completeButton.setVisible(true);

        JLabel nameLabel = new JLabel(event.getName());
        nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD));

        add(nameLabel);
        add(completeButton);



    }


    public void updateUrgency() {

    }

}
