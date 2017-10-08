package ng.hotels.android.app.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.hotels.android.app.R;
import ng.hotels.android.app.adapters.HotelSearchRecyclerViewAdapter;
import ng.hotels.android.app.model.HotelSearch;

public class HotelListingAndSearchActivity extends AppCompatActivity {

    @BindView(R.id.list)
    RecyclerView list;

    private List<HotelSearch> hotelSearchList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_listing_and_search);
        ButterKnife.bind(this);

        if (getSupportActionBar() != null){
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_chevron_left_black_24dp);
            getSupportActionBar().setSubtitle("Lagos");
        }

        setupList();
        setupRecycler();
    }

    private void setupList(){
        if (hotelSearchList == null || hotelSearchList.size() == 0){
            hotelSearchList = new ArrayList<>();
            HotelSearch hotelSearch1 = new HotelSearch("http://res.cloudinary.com/lanre01/image/upload/v1507370197/landscape.png", "Figma Hotels",
                    "N5,000", "1.3 miles from your location", true,
                    true, true, true);

            HotelSearch hotelSearch2 = new HotelSearch("http://res.cloudinary.com/lanre01/image/upload/v1507370197/landscape.png", "Eko Hotel",
                    "N7,000", "2.4 miles from your location", false,
                    true, true, true);

            HotelSearch hotelSearch3 = new HotelSearch("http://res.cloudinary.com/lanre01/image/upload/v1507370197/landscape.png", "Custodian Hotel",
                    "N5,000", "1.3 miles from your location", true,
                    true, false, true);

            hotelSearchList.add(hotelSearch1);
            hotelSearchList.add(hotelSearch2);
            hotelSearchList.add(hotelSearch3);
            hotelSearchList.add(hotelSearch2);
            hotelSearchList.add(hotelSearch1);
        }
    }

    private void setupRecycler(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        HotelSearchRecyclerViewAdapter adapter = new HotelSearchRecyclerViewAdapter(hotelSearchList);
        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);
        list.setHasFixedSize(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_hotel_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_map){
            //Implement navigation to map here
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
