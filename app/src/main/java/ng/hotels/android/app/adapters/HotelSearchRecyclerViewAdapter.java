package ng.hotels.android.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ng.hotels.android.app.R;
import ng.hotels.android.app.model.HotelSearch;

/**
 * Created by abdulrahman on 10/8/17.
 */

public class HotelSearchRecyclerViewAdapter extends RecyclerView.Adapter<HotelSearchRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<HotelSearch> hotelSearchList;


    public HotelSearchRecyclerViewAdapter(List<HotelSearch> hotelSearchList){
        this.hotelSearchList = hotelSearchList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.listing_search_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.hotelSearch = hotelSearchList.get(position);

        holder.hotelName.setText(holder.hotelSearch.getHotelName());
        holder.hotelLocation.setText(holder.hotelSearch.getLocation());
        holder.price.setText(holder.hotelSearch.getPrice());

        if (!holder.hotelSearch.isBarAvailable()){
            holder.bar.setVisibility(View.GONE);
        }

        if (!holder.hotelSearch.isInternetAvailable()){
            holder.internet.setVisibility(View.GONE);
        }

        if (!holder.hotelSearch.isPoolAvailable()){
            holder.pool.setVisibility(View.GONE);
        }

        if (!holder.hotelSearch.isRestaurantAvailable()){
            holder.restaurant.setVisibility(View.GONE);
        }

        Picasso.with(context)
                .load(holder.hotelSearch.getHotelImageUrl())
                .placeholder(R.drawable.hotel_img2)
                .into(holder.hotelImage);
    }

    @Override
    public int getItemCount() {
        return hotelSearchList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        HotelSearch hotelSearch;
        ImageView hotelImage;
        TextView hotelName, hotelLocation, price;
        LinearLayout bar, internet, pool, restaurant;

        public ViewHolder(View view) {
            super(view);

            hotelImage = view.findViewById(R.id.hotel_image);
            hotelName = view.findViewById(R.id.hotel_name);
            hotelLocation = view.findViewById(R.id.hotel_location);
            price = view.findViewById(R.id.price);
            bar = view.findViewById(R.id.bar);
            internet = view.findViewById(R.id.internet);
            pool = view.findViewById(R.id.pool);
            restaurant = view.findViewById(R.id.restaurant);
        }
    }
}
