package ng.hotels.android.app.model;

/**
 * Created by abdulrahman on 10/7/17.
 */

public class Cinemas {

    private String cinemaName;

    private String cinemaImageUrl;

    private String time;

    private String date;

    public Cinemas() {
    }

    public Cinemas(String cinemaName, String cinemaImageUrl, String time, String date) {
        this.cinemaName = cinemaName;
        this.cinemaImageUrl = cinemaImageUrl;
        this.time = time;
        this.date = date;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaImageUrl() {
        return cinemaImageUrl;
    }

    public void setCinemaImageUrl(String cinemaImageUrl) {
        this.cinemaImageUrl = cinemaImageUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
