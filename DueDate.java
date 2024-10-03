import java.io.Serializable;

public class DueDate implements Serializable{
    private static final long serialVersionUID = 1L;
    
    int day;
    int month;
    int year;
    int hour;
    int minute;

    // Constructor with Hour and Minute
    public DueDate(int day, int month, int year, int hour, int minute) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    // Constructor without Hour and Minute
    public DueDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = 0;
        this.minute = 0;
    }

    // To String Method
    public String toString() {
        if (hour == 0 && minute == 0) {
            return day + "/" + month + "/" + year;
        }
        
        return day + "/" + month + "/" + year + " " + hour + ":" + minute;
    }
}
