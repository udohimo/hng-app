package ng.hotels.android.app.model;

/**
 * Created by abdulrahman on 10/8/17.
 */

public class HotelSearch {

    private String hotelImageUrl;
    private String hotelName;
    private String price;
    private String location;
    private boolean isPoolAvailable;
    private boolean isRestaurantAvailable;
    private boolean isBarAvailable;
    private boolean isInternetAvailable;

    public HotelSearch() {
    }

    public HotelSearch(String hotelImageUrl, String hotelName, String price, String location,
                       boolean isPoolAvailable, boolean isRestaurantAvailable,
                       boolean isBarAvailable, boolean isInternetAvailable) {
        this.hotelImageUrl = hotelImageUrl;
        this.hotelName = hotelName;
        this.price = price;
        this.location = location;
        this.isPoolAvailable = isPoolAvailable;
        this.isRestaurantAvailable = isRestaurantAvailable;
        this.isBarAvailable = isBarAvailable;
        this.isInternetAvailable = isInternetAvailable;
    }

    public String getHotelImageUrl() {
        return hotelImageUrl;
    }

    public void setHotelImageUrl(String hotelImageUrl) {
        this.hotelImageUrl = hotelImageUrl;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isPoolAvailable() {
        return isPoolAvailable;
    }

    public void setPoolAvailable(boolean poolAvailable) {
        isPoolAvailable = poolAvailable;
    }

    public boolean isRestaurantAvailable() {
        return isRestaurantAvailable;
    }

    public void setRestaurantAvailable(boolean restaurantAvailable) {
        isRestaurantAvailable = restaurantAvailable;
    }

    public boolean isBarAvailable() {
        return isBarAvailable;
    }

    public void setBarAvailable(boolean barAvailable) {
        isBarAvailable = barAvailable;
    }

    public boolean isInternetAvailable() {
        return isInternetAvailable;
    }

    public void setInternetAvailable(boolean internetAvailable) {
        isInternetAvailable = internetAvailable;
    }
}
