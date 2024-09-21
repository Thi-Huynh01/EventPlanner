import javax.swing.*;

public class AddEventModal extends JDialog {
    private String eventName;
    private int eventType;
    private final String [] types = {"Meeting", "Deadline", "Other"};
/*
    public AddEventModal() {
        dialog = new JDialog();
        panel = new JPanel();

        dialog.setSize(200, 100);
        dialog.add(panel);

    }
  */

    public void show() {

        eventName = JOptionPane.showInputDialog(null,
                "Event Name",
                "Add Event",
                JOptionPane.PLAIN_MESSAGE);

        eventType = JOptionPane.showOptionDialog(null,
                "What type of Event is this?",
                "Event Type",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                types,
                1);

    }

    public int getEventType() {return eventType;}

    public String eventMap() {
        if (this.getEventType() == 0){
            return "Meeting";
        }
        else if (this.getEventType() == 1) {
            return "Deadline";
        }
        return "Event";
    }
    public String getEventName() {return eventName;}

}
