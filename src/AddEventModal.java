import javax.swing.*;
import java.time.LocalDateTime;

public class AddEventModal extends JDialog {
    private String eventName;
    private int eventType;
    private final String [] types = {"Meeting", "Deadline", "Other"};
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;

    @Override
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
                0);

            getTime(eventType);


    }

    public void getTime (int eventType) {
        String month, day, year, time, time_string, location;

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

        time_string = year + "-" + month + "-" + day + "T" + time;
        System.out.println(time_string);

        startTime = LocalDateTime.parse(time_string);

        if (eventType == 0) {

            time = JOptionPane.showInputDialog(null,
                    "Enter the End Time\n Time (HH:MM):",
                    "Date",
                    JOptionPane.PLAIN_MESSAGE);

            time_string = year + "-" + month + "-" + day + "T" + time;
            endTime = LocalDateTime.parse(time_string);

            location = JOptionPane.showInputDialog(null,
                    "Enter the location of this meeting:",
                    "Location",
                    JOptionPane.PLAIN_MESSAGE);

            this.location = location;
        }

    }

    public String returnLocation () {
        return this.location;
    }

    public LocalDateTime getStartTime() {

        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
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
