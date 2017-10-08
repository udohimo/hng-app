package ng.hotels.android.app.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ng.hotels.android.app.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BookingHistoryDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BookingHistoryDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookingHistoryDetailsFragment extends Fragment {


    private OnFragmentInteractionListener mListener;
    @BindView(R.id.depature_town)
    TextView depatureTown;
    @BindView(R.id.arrival_town)
    TextView arrivalTown;
    @BindView(R.id.date_view)
    TextView dateView;
    @BindView(R.id.date_identifier)
    TextView dateIdentifier;
    @BindView(R.id.day_month)
    TextView dayMonth;
    @BindView(R.id.booking_type)
    ImageView bookingType;
    @BindView(R.id.airline_name)
    TextView airlineName;
    @BindView(R.id.booking_cost)
    TextView bookingCost;
    @BindView(R.id.flight_code)
    TextView flightCode;
    @BindView(R.id.terminal_number)
    TextView terminalNumber;
    @BindView(R.id.seat_number)
    TextView seatNumber;
    @BindView(R.id.zone_number)
    TextView zoneNumber;
    @BindView(R.id.depature_time)
    TextView depatureTime;
    @BindView(R.id.arrival_time)
    TextView arrivalTime;
    @BindView(R.id.pnr_code)
    TextView pnrCode;
    @BindView(R.id.bar_code)
    ImageView barCode;

    public BookingHistoryDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment BookingHistoryDetailsFragment.
     */
    public static BookingHistoryDetailsFragment newInstance() {
        BookingHistoryDetailsFragment fragment = new BookingHistoryDetailsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking_history_details, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(getContext())
                .load("http://res.cloudinary.com/lanre01/image/upload/v1507308086/barcode_xkuioz.jpg")
                .placeholder(R.drawable.hotel_img5)
                .into(barCode);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @OnClick(R.id.book_again)
    public void bookAgain(){

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

        void onFragmentInteraction();
    }
}
