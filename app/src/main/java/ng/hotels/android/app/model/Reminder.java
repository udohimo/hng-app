package ng.hotels.android.app.model;

/**
 * Created by abdulrahman on 10/7/17.
 */

public class Reminder {

    private String reminderUrl;
    private String flight;
    private String airline;
    private String days;

    public Reminder() {
    }

    public Reminder(String reminderUrl, String flight, String airline, String days) {
        this.reminderUrl = reminderUrl;
        this.flight = flight;
        this.airline = airline;
        this.days = days;
    }

    public String getReminderUrl() {
        return reminderUrl;
    }

    public void setReminderUrl(String reminderUrl) {
        this.reminderUrl = reminderUrl;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
}
