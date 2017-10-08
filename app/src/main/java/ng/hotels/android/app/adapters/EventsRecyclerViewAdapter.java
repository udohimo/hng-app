package ng.hotels.android.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ng.hotels.android.app.R;
import ng.hotels.android.app.ui.fragments.EventsFragment.OnFragmentInteractionListener;

/**
 * Created by abdulrahman on 10/7/17.
 */

public class EventsRecyclerViewAdapter extends RecyclerView.Adapter<EventsRecyclerViewAdapter.ViewHolder>{

    private OnFragmentInteractionListener mListener;

    private Context context;
    private String[] images;

    public EventsRecyclerViewAdapter(String[] images, OnFragmentInteractionListener mListener){
       this.images = images;
       this.mListener = mListener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.events_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context)
                .load(images[position])
                .placeholder(R.drawable.hotel_img1)
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.event_image);
        }
    }
}
