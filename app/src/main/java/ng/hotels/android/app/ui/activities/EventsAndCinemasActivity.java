package ng.hotels.android.app.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import ng.hotels.android.app.R;
import ng.hotels.android.app.ui.fragments.CinemasFragment;
import ng.hotels.android.app.ui.fragments.EventsFragment;

public class EventsAndCinemasActivity extends AppCompatActivity implements
        CinemasFragment.OnFragmentInteractionListener, EventsFragment.OnFragmentInteractionListener{

    private EventsFragment eventsFragment;
    private CinemasFragment cinemasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_and_cinemas);

        Intent intent = getIntent();
        if (intent.hasExtra("page")){
            int page = intent.getIntExtra("page", 0);
            if (page == 0){
                showEventsFragment();
            } else if (page == 1){
                showCinemasFragment();
            }
        }
    }

    private void showEventsFragment(){
        if (eventsFragment == null)
            eventsFragment = EventsFragment.newInstance();
        setupToolbar("EVENTS");
        loadFragment(eventsFragment);
    }

    private void showCinemasFragment(){
        if (cinemasFragment == null)
            cinemasFragment = CinemasFragment.newInstance();
        setupToolbar("CINEMAS");
        loadFragment(cinemasFragment);
    }

    private void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }

    private void setupToolbar(String title){
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_chevron_left_black_24dp);
        }
    }

    private void showMainPage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_events, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_notification){
            //write code for menu here
            return  true;
        } else if (id == R.id.action_search) {
            //write code for menu option here
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        showMainPage();
    }

    @Override
    public void onFragmentInteraction() {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
