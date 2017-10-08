package ng.hotels.android.app.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ng.hotels.android.app.R;
import ng.hotels.android.app.model.Reminder;

/**
 * Created by abdulrahman on 10/7/17.
 */

public class FlightReminderRecyclerViewAdapter extends RecyclerView.Adapter<FlightReminderRecyclerViewAdapter.ViewHolder> {

    private List<Reminder> reminderList;
    private Context context;

    public FlightReminderRecyclerViewAdapter(Context context, List<Reminder> reminderList) {
        this.context = context;
        this.reminderList = reminderList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flight_reminder_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.reminder = reminderList.get(position);
        holder.flight.setText(holder.reminder.getFlight());
        holder.airline.setText(holder.reminder.getAirline());
        holder.daysLeft.setText(holder.reminder.getDays());

        Picasso.with(context)
                .load(holder.reminder.getReminderUrl())
                .into(holder.reminderImage);

        holder.overflowMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(context, holder.overflowMenu);

                MenuInflater inflater = ((Activity)context).getMenuInflater();

                inflater.inflate(R.menu.item_flight_reminder, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        return false;
                    }
                });
                popup.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return reminderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        Reminder reminder;
        ImageView reminderImage;
        TextView flight;
        TextView airline;
        TextView daysLeft;

        TextView overflowMenu;

        public ViewHolder(View view) {
            super(view);

            reminderImage = view.findViewById(R.id.reminder_image);
            flight = view.findViewById(R.id.flight);
            airline = view.findViewById(R.id.airline);
            daysLeft = view.findViewById(R.id.reminder_message);

            overflowMenu = view.findViewById(R.id.menu);
        }
    }
}
