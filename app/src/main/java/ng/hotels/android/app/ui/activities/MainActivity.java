package ng.hotels.android.app.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import ng.hotels.android.app.R;
import ng.hotels.android.app.ui.fragments.PendingPaymentReminderFragment;
import ng.hotels.android.app.ui.fragments.RequestDialogLoginRegisterFragment;
import ng.hotels.android.app.ui.fragments.SlowNetworkOptionsFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements
        PendingPaymentReminderFragment.OnFragmentInteractionListener,
        SlowNetworkOptionsFragment.OnFragmentInteractionListener{

    private PendingPaymentReminderFragment pendingPaymentReminderFragment;
    private SlowNetworkOptionsFragment slowNetworkOptionsFragment;
    private RequestDialogLoginRegisterFragment requestDialogLoginRegisterFragment;
    private ScrollView viewContainer;
    private FrameLayout frameLayout;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        frameLayout = findViewById(R.id.container);
        viewContainer = findViewById(R.id.view_container);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void showFragment() {
        frameLayout.setVisibility(View.VISIBLE);
        viewContainer.setVisibility(View.GONE);
    }

    private void showPendingPaymentReminderFragment(){
        if (pendingPaymentReminderFragment == null)
            pendingPaymentReminderFragment = PendingPaymentReminderFragment.newInstance();
        pendingPaymentReminderFragment.show(getSupportFragmentManager(), "Payment reminder");
        pendingPaymentReminderFragment.setCancelable(true);
    }

    private void showSlowNetworkOptions(){
        if (slowNetworkOptionsFragment == null)
            slowNetworkOptionsFragment = SlowNetworkOptionsFragment.newInstance();
        slowNetworkOptionsFragment.setCancelable(true);
        slowNetworkOptionsFragment.show(getSupportFragmentManager(), "Slow Network Options");
    }

    private void showReuestLogin(){
        if (requestDialogLoginRegisterFragment == null)
            requestDialogLoginRegisterFragment = RequestDialogLoginRegisterFragment.newInstance();
        requestDialogLoginRegisterFragment.setCancelable(true);
        requestDialogLoginRegisterFragment.show(getSupportFragmentManager(), "Request Login");
    }

    @Override
    public void onBackPressed() {
        if (pendingPaymentReminderFragment != null && pendingPaymentReminderFragment.isAdded()) {
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openHompage(View view) {
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    }

    public void openLoginpage(View view) {
        startActivity(new Intent(getApplicationContext(), UserAuthenticationActivity.class));
    }



    public void openSingleHotel(View view) {
        startActivity(new Intent(getApplicationContext(), SingleHotelPageActivity.class));
    }

    public void openPaymentSuccess(View view) {
        startActivity(new Intent(getApplicationContext(), SuccessfulBookingActivity.class));
    }

    public void openFlightDetails(View view) {
        startActivity(new Intent(getApplicationContext(), FlightDetailActivity.class));
    }

    public void openBookingDetails(View view) {
        startActivity(new Intent(getApplicationContext(), BookingDetailsActivity.class));
    }

    public void openSettings(View view) {
        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
    }

    public void openFlightTracking(View view) {
        startActivity(new Intent(getApplicationContext(), MapsActivity.class));
    }

    public void openFlightReceipt(View view) {
        startActivity(new Intent(getApplicationContext(), FlightReservationReceiptActivity.class));
    }

    public void HelpPage(View View){
        startActivity(new Intent(getApplicationContext(),HelpActivity.class));
    }

    public void openGallery(View View){
        startActivity(new Intent(getApplicationContext(),GalleryActivity.class));
    }

    public void openInvite(View view) {
        startActivity(new Intent(getApplicationContext(), InviteFriendsActivity.class));
    }

    public void openHistoryDetail(View view) {
        Intent intent = new Intent(getApplicationContext(), BookingHistoryActivity.class);
        intent.putExtra("page", 0);
        startActivity(intent);
    }

    public void openCustomerServiceChat(View view){
        startActivity(new Intent(this,CustomerServiceStartConversationActivity.class));
    }

    public void openHistoryList(View view) {
        Intent intent = new Intent(getApplicationContext(), BookingHistoryActivity.class);
        intent.putExtra("page", 1);
        startActivity(intent);
    }
    public void openPaymentReminder(View view) {
        showPendingPaymentReminderFragment();
    }

    public void openConfirmBooking(View view) {
        Intent intent =new Intent(getApplicationContext(), BookingActivity.class);
        intent.putExtra("page", 3);
        startActivity(intent);
    }

    public void openCinemas(View view) {
        Intent intent = new Intent(getApplicationContext(), EventsAndCinemasActivity.class);
        intent.putExtra("page",1);
        startActivity(intent);
    }

    public void openEvents(View view) {
        Intent intent = new Intent(getApplicationContext(), EventsAndCinemasActivity.class);
        intent.putExtra("page", 0);
        startActivity(intent);
    }
    public void openMoCapture(View view){
        Intent intent = new Intent(getApplicationContext(), MocaptureActivity.class);
        startActivity(intent);
    }
    public void openATMFinder(View view){
        Intent intent = new Intent(getApplicationContext(), ATMFinder_Activity.class);
        startActivity(intent);
    }
    public void openUserProfile(View view){
        Intent intent = new Intent(getApplicationContext(), UserProfileActivity.class);
        intent.putExtra("test", "test");
        startActivity(intent);
    }
    public void openLoyaltyCoin(View view){
        Intent intent = new Intent(getApplicationContext(), LoyaltyCoinActivity.class);
        startActivity(intent);
    }
    public void openHotelSearchList(View view){
        Intent intent = new Intent(getApplicationContext(), HotelListingAndSearchActivity.class);
        startActivity(intent);
    }
    public void openLanguageSetting(View view){
        Intent intent = new Intent(getApplicationContext(), LanguageSettingActivity.class);
        startActivity(intent);
    }
    public void openLoginReminder(View view){
        showReuestLogin();
    }
    public void openReviewStay(View view){
        Intent intent = new Intent(getApplicationContext(), ReviewStayActivity.class);
        startActivity(intent);
    }
    public void openSlowNetworkReminder(View view){
        showSlowNetworkOptions();
    }
    public void openAnalytics(View view){
        Intent intent = new Intent(getApplicationContext(), AnalyticsActivity.class);
        startActivity(intent);
    }
    public void openFlightReminder(View view){
        Intent intent = new Intent(getApplicationContext(), FlightReminderActivity.class);
        startActivity(intent);
    }
    public void openCheckout(View view){
        Intent intent = new Intent(getApplicationContext(), CheckoutActivity.class);
        startActivity(intent);
    }

    @Override
    public void onConfirmClicked() {

    }

    @Override
    public void onFragmentInteraction() {

    }
}
