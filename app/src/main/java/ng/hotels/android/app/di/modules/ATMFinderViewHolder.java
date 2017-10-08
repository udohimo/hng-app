package ng.hotels.android.app.di.modules;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ng.hotels.android.app.R;

/**
 * Created by Arinze 10/7/2017.
 */

public class ATMFinderViewHolder  extends RecyclerView.ViewHolder {

    @BindView(R.id.bank_name) public TextView Bank_Name;
    @BindView(R.id.bank_direction) public TextView Bank_Direction;
    @BindView(R.id.bank_distance) public TextView Bank_Distance;
    @BindView(R.id.bank_image) public ImageView Bank_Image_Url;

    public ATMFinderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}

