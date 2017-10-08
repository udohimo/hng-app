package ng.hotels.android.app.ui.activities;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;


import ng.hotels.android.app.R;
import ng.hotels.android.app.adapters.GalleryAdapter;
import ng.hotels.android.app.model.Hotels;

public class GalleryActivity extends AppCompatActivity {

    private List<Hotels> hotelsList = new ArrayList<>();
    private RecyclerView galleryRecyclerView;
    private GalleryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
       // getActionBar().setDisplayHomeAsUpEnabled(true);

        galleryRecyclerView = (RecyclerView) findViewById(R.id.hotels_list);
        mAdapter = new GalleryAdapter(hotelsList);
       LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

//        StackCardLayoutManager stackCardLayoutManager = new StackCardLayoutManager(StackCardLayoutManager.VERTICAL,true, new StackCardPostLayout());
//        stackCardLayoutManager.setStackOrder(StackCardLayoutManager.OUT_STACK_ORDER);
//        stackCardLayoutManager.setNumberOrder(StackCardLayoutManager.NEGATIVE_ORDER);

        galleryRecyclerView.setLayoutManager(layoutManager);

        galleryRecyclerView.setHasFixedSize(true);
        galleryRecyclerView.setAdapter(mAdapter);
        prepareData();
    }


    private void prepareData() {


        Hotels item = new Hotels("Esuites","Asokoro, Lagos", "₦20,000",3, R.drawable.top);
        hotelsList.add(item);
        item = new Hotels("Esuites","Asokoro, Lagos", "₦20,000",3, R.drawable.top);
        hotelsList.add(item);
        item = new Hotels("Esuites","Asokoro, Lagos", "₦20,000",3, R.drawable.top);
        hotelsList.add(item);
        item = new Hotels("Esuites","Asokoro, Lagos", "₦20,000",3, R.drawable.top);
        hotelsList.add(item);



        mAdapter.notifyDataSetChanged();
    }

}
