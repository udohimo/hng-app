package ng.hotels.android.app.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import ng.hotels.android.app.R;
import ng.hotels.android.app.ui.fragments.UserProfileIndexFragment;


public class UserProfileActivity extends AppCompatActivity implements UserProfileIndexFragment.OnFragmentInteractionListener {
    private UserProfileIndexFragment userProfileIndexFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Intent intent = getIntent();
        if (intent.hasExtra("test")) {
            loadIndex();
        }
    }

    private void loadIndex() {
        if (userProfileIndexFragment == null)
            userProfileIndexFragment = UserProfileIndexFragment.newInstance();
        loadFragment(userProfileIndexFragment);
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.root, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }

    private void showHome(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        showHome();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
