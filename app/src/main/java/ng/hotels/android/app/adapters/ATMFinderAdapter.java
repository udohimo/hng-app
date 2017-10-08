package ng.hotels.android.app.adapters;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.squareup.picasso.Picasso;

import java.util.List;

import ng.hotels.android.app.R;
import ng.hotels.android.app.di.modules.ATMFinderViewHolder;
import ng.hotels.android.app.model.ATMFinderModel;

/**
 * Created by Arinze on 10/8/2017.
 */

public class ATMFinderAdapter extends RecyclerView.Adapter<ATMFinderViewHolder> {

    private Context Context;
    private List<ATMFinderModel> ATMObjects;

    public ATMFinderAdapter(Context context,List<ATMFinderModel> atm_objects){
        this.Context = context;
        this.ATMObjects = atm_objects;
    }

    @Override
    public ATMFinderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(Context).inflate(R.layout.atm_finder_recycler_view_layout, parent, false);
        return new ATMFinderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ATMFinderViewHolder holder, final int position) {
        ATMFinderModel atm_Object = ATMObjects.get(position);
        holder.Bank_Name.setText(atm_Object.getBank_Name());
        holder.Bank_Distance.setText(atm_Object.getBank_Distance());
        holder.Bank_Direction.setText(atm_Object.getBank_Direction());
        Picasso.with(Context).load(atm_Object.getBank_Image_Url()).resize(85,65).into(holder.Bank_Image_Url);
    }

    @Override
    public int getItemCount(){
        return ATMObjects.size();
    }



}
