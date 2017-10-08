package ng.hotels.android.app.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.hotels.android.app.R;

/**
 * Created by abdulrahman on 10/8/17.
 */

public class LanguageSettingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @BindView(R.id.spinner_nationality)
    Spinner countrySpinner;
    @BindView(R.id.spinner_language)
    Spinner languageSpinner;

    private String[] countryArray;
    private String[] languageArray;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_language_settings);
        ButterKnife.bind(this);

        countryArray = new String[]{"Country", "Armenia","Brazil","Nigeria", "Portugal",
                "Saudi Arabia", "United Kingdom", "United States"};
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(this, android.R.
                layout.simple_spinner_dropdown_item, countryArray);
        countrySpinner.setAdapter(countryAdapter);
        countrySpinner.setOnItemSelectedListener(this);

        languageArray = new String[]{"Select", "Arabic", "English", "French", "Portuguese", "Spanish"};
        ArrayAdapter<String> languageAdapter = new ArrayAdapter<String>(this, R.layout.
                support_simple_spinner_dropdown_item, languageArray);
        languageSpinner.setAdapter(languageAdapter);
        languageSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) view).setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
