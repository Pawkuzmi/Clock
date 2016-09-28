package clock;

/**
 *
 * @author Paweł Kuźmicki
 */
public class Event {
    
    private int ID;
    private String name;
    private String dayOfMonth;
    private String hour;
    private String description;

    public Event(String name, String dayOfMonth, String hour, String description) {
        this.name = name;
        this.dayOfMonth = dayOfMonth;
        this.hour = hour;
        this.description = description;
    }

    public Event(int ID, String name, String dayOfMonth, String hour, String description) {
        this.ID = ID;
        this.name = name;
        this.dayOfMonth = dayOfMonth;
        this.hour = hour;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString(){
        String i = Integer.toString(this.ID);
        
        return i + ". " + this.name + ": " + this.hour + " " + this.description;
    }
}
