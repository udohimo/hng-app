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
import ng.hotels.android.app.adapters.FlightReminderRecyclerViewAdapter;
import ng.hotels.android.app.model.Reminder;

public class FlightReminderActivity extends AppCompatActivity {

    private List<Reminder> reminderList = null;
    @BindView(R.id.list)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_reminder);
        ButterKnife.bind(this);

        if (getSupportActionBar() != null){
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_chevron_left_black_24dp);

        }
        setupList();
        setupRecycler();
    }

    private void setupList(){

        if (reminderList == null || reminderList.size() == 0){
            reminderList = new ArrayList<>();
            Reminder reminder1 = new Reminder("http://res.cloudinary.com/lanre01/image" +
                    "/upload/v1507370197/landscape.png", "AJ419", "Aero Contractors",
                    "Departing to Kano in 3 days time");
            Reminder reminder2 = new Reminder("http://res.cloudinary.com/lanre01/image/" +
                    "upload/v1507370197/landscape.png", "BX414", "Air Peace",
                    "Return flight to Abuja in 1 week time");
            Reminder reminder3 = new Reminder("http://res.cloudinary.com/lanre01/image/" +
                    "upload/v1507370197/landscape.png", "PW666", "Arik Airline",
                    "Departing to Uyo in 3 weeks time");
            reminderList.add(reminder1);
            reminderList.add(reminder2);
            reminderList.add(reminder3);
            reminderList.add(reminder1);
        }
    }

    private void setupRecycler(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        FlightReminderRecyclerViewAdapter adapter = new FlightReminderRecyclerViewAdapter(this, reminderList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_flight_reminder, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_reminder_settings:
                return true;
            case R.id.action_cancel_all:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
