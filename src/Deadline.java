import java.time.LocalDateTime;

public class Deadline extends Event implements Completable {
    public boolean complete = false;

    // Since this class extends Event, super() is needed to inherit the data
    public Deadline(String name, LocalDateTime deadline) {
       super(name, deadline);
    }

    // Override void complete and boolean iscomplete from Completable
    @Override
    public void complete() {
        complete = true;
    }

    @Override
    public boolean isComplete() {
        return complete;
    }
}
