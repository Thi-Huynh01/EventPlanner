// RELATED TO LAB 4

import javax.swing.*;

public class EventFactory {

    private final String [] types = {"Meeting", "Deadline", "Other"}; // Options for dialog box. 'Other labels the event 'Event' but shares the properties of Deadline

    public int eventType () {

        // Delegated the determination of the event type to this method, utilized in AddEventModal.java
        int type = JOptionPane.showOptionDialog(null,
                "What type of Event is this?",
                "Event Type",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                types,
                0);

        if (type == 0) {
            System.out.println("EVENT TYPE: MEETING");
        }
        else if (type == 1) {
            System.out.println("EVENT TYPE: DEADLINE");
        }

        return type;
    }

    // Returns the name of the event, utilized in AddEventModal.java
    public String getEventName () {
        String evName = JOptionPane.showInputDialog(null,
                "Event Name",
                "Add Event",
                JOptionPane.PLAIN_MESSAGE);

        System.out.println("EVENT NAME: " + evName);

        return evName;
    }

}
