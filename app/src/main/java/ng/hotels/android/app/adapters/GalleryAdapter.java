package ng.hotels.android.app.adapters;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;



import java.util.List;

import ng.hotels.android.app.R;
import ng.hotels.android.app.model.Hotels;

/**
 * Created by ESIDEM jnr on 10/7/2017.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private List<Hotels> modelArrayList;
    public GalleryAdapter(List<Hotels> models) {
        this.modelArrayList = models;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int idForListItem = R.layout.gallery_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean attach = false;

        View view = inflater.inflate(idForListItem, parent, attach);
        ViewHolder mViewHolder = new ViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Hotels item = modelArrayList.get(position);

//        RoundedBitmapDrawable dr = RoundedBitmapDrawableFactory.create(res, item.getHotel_image());
//        dr.setCornerRadius(10);
//        holder.hotelImage.setImageDrawable(dr);
        holder.hotelImage.setImageResource(item.getHotel_image());
        holder.hotelName.setText(item.getHotel_name());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = holder.itemView.getContext();


            }
        });


    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView hotelImage;
        public TextView hotelName,hotelPrice, hotelLocation;
        public RatingBar hotelRating;


        public ViewHolder(View itemView) {
            super(itemView);
            hotelImage = (ImageView) itemView.findViewById(R.id.hotel_image);
            hotelName = (TextView) itemView.findViewById(R.id.hotel_name);
            hotelPrice = (TextView) itemView.findViewById(R.id.hotel_prize);
            hotelLocation= (TextView) itemView.findViewById(R.id.hotel_location);
            hotelRating = itemView.findViewById(R.id.hotel_rating);


        }

       /* void bind(int index) {
            picture.setImageResource(index);
            name.setText(String.valueOf(index));
        }*/
    }
}
