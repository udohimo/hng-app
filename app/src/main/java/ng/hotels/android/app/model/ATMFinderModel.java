package ng.hotels.android.app.model;

/**
 * Created by Arinze on 10/7/2017.
 */

public class ATMFinderModel {


    private final String Bank_Name;
    private final String Bank_Distance;
    private final String Bank_Direction;
    private final String Bank_Image_Url;

    public ATMFinderModel( String bank_name, String bank_distance, String bank_direction, String bank_image_url){

        this.Bank_Name = bank_name;
        this.Bank_Distance = bank_distance;
        this.Bank_Direction = bank_direction;
        this.Bank_Image_Url = bank_image_url;    }


    public String getBank_Name(){
        return Bank_Name;
    }
    public String getBank_Distance(){
        return Bank_Distance;
    }
    public String getBank_Direction(){
        return Bank_Direction;
    }
    public String getBank_Image_Url(){
        return Bank_Image_Url;
    }
}
