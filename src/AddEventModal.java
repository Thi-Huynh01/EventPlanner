import javax.swing.*;
import java.time.LocalDateTime;

public class AddEventModal extends JDialog {
    private String eventName;
    private int eventType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;

    @Override
    public void show() {

        EventFactory eventFactory = new EventFactory();

        // Prompt for name of event
        eventName = eventFactory.getEventName();

        //Prompts the user to enter the name of the event: Deadline or Meeting
        eventType = eventFactory.eventType();

        // eventType will yield a 0, 1, or 2. This will be passed into getTime()
        getTime(eventType);

    }

    public void getTime (int eventType) {
        String month, day, year, time, time_string, location;

        // Get numerical data of month, day, year, and time.
        month = JOptionPane.showInputDialog(null,
                "Enter the Date\n Month (MM):",
                "Date",
                JOptionPane.PLAIN_MESSAGE);

        day = JOptionPane.showInputDialog(null,
                "Enter the Date\n Day (DD):",
                "Date",
                JOptionPane.PLAIN_MESSAGE);

        year = JOptionPane.showInputDialog(null,
                "Enter the Date\n Year (YYYY):",
                "Date",
                JOptionPane.PLAIN_MESSAGE);

        time = JOptionPane.showInputDialog(null,
                "Enter the Time\n Time (HH:MM):",
                "Date",
                JOptionPane.PLAIN_MESSAGE);

        // Concatenate the date into a string to pass to a parser
        time_string = year + "-" + month + "-" + day + "T" + time;

        // addEventModal's start time will be parsed.
        startTime = LocalDateTime.parse(time_string);

        // If the eventType is a meeting, get the endTime and parse that into the endTime variable
        if (eventType == 0) {

            time = JOptionPane.showInputDialog(null,
                    "Enter the End Time\n Time (HH:MM):",
                    "Date",
                    JOptionPane.PLAIN_MESSAGE);

            time_string = year + "-" + month + "-" + day + "T" + time;
            endTime = LocalDateTime.parse(time_string);

            // Get location of meeting

            location = JOptionPane.showInputDialog(null,
                    "Enter the location of this meeting:",
                    "Location",
                    JOptionPane.PLAIN_MESSAGE);

            this.location = location;
        }

    }

    // If return the type of event based on the value yielded from eventType
    public String eventMap() {
        if (this.getEventType() == 0){
            return "Meeting";
        }
        else if (this.getEventType() == 1) {
            return "Deadline";
        }
        return "Event";
    }

    // Getters

    public String returnLocation () {
        return this.location;
    }

    public LocalDateTime getStartTime() {

        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public int getEventType() {
        return eventType;
    }


    public String getEventName() {
        return eventName;
    }

}
