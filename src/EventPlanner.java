import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class EventPlanner {
    public static void addDefaultEvents (EventPanel events) {
        Deadline deadL = new Deadline("Project", LocalDateTime.of(2024, 9, 25, 15, 0));
        Meeting meet = new Meeting("OOP w/Java", LocalDateTime.of(2024, 9, 20, 15,0), LocalDateTime.of(2024,9,20, 15, 50,0), "Room 339");

    }

    public static void main(String[] args) {

       // EventPanel events = new EventPanel();
        EventListPanel eventList = new EventListPanel();
        //addDefaultEvents(events);

        JFrame frame = new JFrame();
        frame.setTitle("Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(eventList);
        frame.pack();
        frame.setVisible(true);

    }

}
