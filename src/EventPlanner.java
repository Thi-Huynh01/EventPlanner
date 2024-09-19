import java.time.LocalDateTime;

public class EventPlanner {
    public static void addDefaultEvents (EventPanel events) {

    }

    public static void main(String[] args) {
        EventPanel events = new EventPanel();
        addDefaultEvents(events);
        LocalDateTime start = LocalDateTime.of(2024, 10, 7, 15, 0);
        LocalDateTime end = LocalDateTime.of(2024, 10, 7, 16, 0);

        Meeting m = new Meeting("Good morning", start, end, "Batesville");
    }

}
