import java.time.LocalDateTime;

public interface EventInterface {

    // Implement these methods
    public LocalDateTime getDateTime();
    public String getName();

    // Override compareTo method to sort the events by date
    int compareTo(Event e);
}
