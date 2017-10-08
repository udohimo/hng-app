package ng.hotels.android.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ng.hotels.android.app.R;
import ng.hotels.android.app.model.Cinemas;
import ng.hotels.android.app.ui.fragments.CinemasFragment.OnFragmentInteractionListener;

/**
 * Created by abdulrahman on 10/7/17.
 */

public class CinemasRecyclerViewAdapter extends RecyclerView.Adapter<CinemasRecyclerViewAdapter.ViewHolder>{

    private List<Cinemas> cinemasList;
    private OnFragmentInteractionListener mListener;
    private Context context;

    public CinemasRecyclerViewAdapter(List<Cinemas> cinemasList, OnFragmentInteractionListener mListener){
        this.cinemasList = cinemasList;
        this.mListener = mListener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.cinemas_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.cinema = cinemasList.get(position);
        holder.date.setText(holder.cinema.getDate());
        holder.time.setText(holder.cinema.getTime());
        holder.cinemaName.setText(holder.cinema.getCinemaName());

        Picasso.with(context)
                .load(holder.cinema.getCinemaImageUrl())
                .placeholder(R.drawable.hotel_img1)
                .into(holder.cinemaImage);
    }

    @Override
    public int getItemCount() {
        return cinemasList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public Cinemas cinema;
        public ImageView cinemaImage;
        public TextView cinemaName;
        public TextView date;
        public TextView time;

        public ViewHolder(View view) {
            super(view);

            cinemaImage = view.findViewById(R.id.cinema_image);
            cinemaName = view.findViewById(R.id.cinema_name);
            date = view.findViewById(R.id.date);
            time = view.findViewById(R.id.time);
        }
    }
}
