package ng.hotels.android.app.ui.activities;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.hotels.android.app.R;
import ng.hotels.android.app.adapters.ATMFinderAdapter;
import ng.hotels.android.app.model.ATMFinderModel;


public class ATMFinder_Activity extends Activity {

    @BindView(R.id.atm_recyclerView)RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atmfinder_);

        ButterKnife.bind(this);
        LinearLayoutManager LinearLayout = new LinearLayoutManager(ATMFinder_Activity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(LinearLayout);
        recyclerView.setHasFixedSize(true);
        ATMFinderAdapter mAdapter = new ATMFinderAdapter(ATMFinder_Activity.this, getTestData());
        recyclerView.setAdapter(mAdapter);
    }

    public List<ATMFinderModel> getTestData(){
        List<ATMFinderModel> ATM = new ArrayList<ATMFinderModel>();
        ATM.add(new ATMFinderModel("FirstBank","5km west of here","Opp. New Heaven","https://upload.wikimedia.org/wikipedia/en/8/84/FirstBank_Logo.jpg.png "));
        ATM.add(new ATMFinderModel("FCMB","200 Km North","Airport road","https://www.unionbankng.com/wp-content/uploads/2017/02/unionlogo-1.png"));
        ATM.add(new ATMFinderModel("Union Bank","100km south of here","New heaven junction 042","http://investorsking.com/wp-content/uploads/2016/08/First-City-Monument-Bank-FCMB.jpg"));
        return ATM;
    }

}
