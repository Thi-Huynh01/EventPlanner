import java.time.LocalDateTime;

public abstract class Event implements Comparable <Event> {
    public String name; // Event Name
    public LocalDateTime dateTime; // Date and time of event

    //Constructor
    public Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    // Below are the setters and getters

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getName() {
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }

    // Override compareTo method to sort the events by date
    @Override
    public int compareTo(Event e) {
        return dateTime.compareTo(e.dateTime);
    }

}
