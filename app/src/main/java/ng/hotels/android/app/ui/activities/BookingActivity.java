package ng.hotels.android.app.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.hotels.android.app.R;
import ng.hotels.android.app.ui.fragments.ConfirmBookingFragment;
import ng.hotels.android.app.ui.fragments.PaymentOptionsFragment;
import ng.hotels.android.app.ui.fragments.YourInfoFragment;


public class BookingActivity extends AppCompatActivity implements
        YourInfoFragment.OnFragmentInteractionListener,
        PaymentOptionsFragment.OnFragmentInteractionListener,
        ConfirmBookingFragment.OnFragmentInteractionListener {

    @BindView(R.id.step1_complete)
    View step1Complete;
    @BindView(R.id.step2)
    ImageView step2;
    @BindView(R.id.step2_complete)
    View step2Complete;
    @BindView(R.id.complete)
    ImageView complete;
    @BindView(R.id.step2_text)
    TextView step2Text;
    @BindView(R.id.complete_text)
    TextView completeText;

    private YourInfoFragment yourInfoFragment;
    private ConfirmBookingFragment confirmBookingFragment;
    private PaymentOptionsFragment paymentOptionsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        if (intent.hasExtra("page")){
            int page = intent.getIntExtra("page", 0);
            if (page == 0){
                showYourInfoFragment();
            } else if (page == 1){
                showPaymentOptionsFragment();
            } else if (page == 3){
                showConfirmBookingFragment();
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (confirmBookingFragment != null && confirmBookingFragment.isAdded()){
            showYourInfoFragment();
        } else if (yourInfoFragment != null && yourInfoFragment.isAdded()){
            showMainPage();
        }
    }

    private void showMainPage(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void setupToolbar(String title){
        if (getSupportActionBar() != null){
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_chevron_left_black_24dp);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle(title);
        }
    }

    private void showYourInfoFragment() {
        setupToolbar("Check out");
        step1Complete.setBackgroundColor(ContextCompat.getColor(this, R.color.background));
        step2.setImageResource(R.drawable.circle_normal);
        step2Complete.setBackgroundColor(ContextCompat.getColor(this, R.color.background));
        complete.setImageResource(R.drawable.circle_normal);
        completeText.setTextColor(ContextCompat.getColor(this, R.color.background));
        step2Text.setTextColor(ContextCompat.getColor(this, R.color.background));
        if(yourInfoFragment == null)
            yourInfoFragment = YourInfoFragment.newInstance();
        loadFragment(yourInfoFragment);
    }

    private void showConfirmBookingFragment() {
        setupToolbar("Confirm Booking");
        step1Complete.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary));
        step2.setImageResource(R.drawable.circle_complete);
        step2Text.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        step2Complete.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        complete.setImageResource(R.drawable.circle_complete);
        completeText.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        if (confirmBookingFragment == null)
            confirmBookingFragment = ConfirmBookingFragment.newInstance();
        loadFragment(confirmBookingFragment);
    }

    private void showPaymentOptionsFragment() {
        setupToolbar("Payment Option");
        step1Complete.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary));
        step2.setImageResource(R.drawable.circle_complete);
        step2Text.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        step2Complete.setBackgroundColor(ContextCompat.getColor(this, R.color.background));
        complete.setImageResource(R.drawable.circle_normal);
        completeText.setTextColor(ContextCompat.getColor(this, R.color.background));
        if (paymentOptionsFragment == null)
            paymentOptionsFragment = PaymentOptionsFragment.newInstance();
        FragmentManager fm = getSupportFragmentManager();
        paymentOptionsFragment.setCancelable(true);
        paymentOptionsFragment.show(fm, "Payment");
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.booking_views_container, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }


    @Override
    public void onProceedClicked(String title, String country, String email, String phone, String name) {
        showPaymentOptionsFragment();
    }

    @Override
    public void onConfirmClicked() {

    }

    @Override
    public void onOptionSelected(String option) {
        showConfirmBookingFragment();
    }

}