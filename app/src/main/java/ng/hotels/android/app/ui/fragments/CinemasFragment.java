package ng.hotels.android.app.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ng.hotels.android.app.R;
import ng.hotels.android.app.adapters.CinemasRecyclerViewAdapter;
import ng.hotels.android.app.model.Cinemas;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CinemasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CinemasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CinemasFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private List<Cinemas> cinemasList = null;

    public CinemasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment CinemasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CinemasFragment newInstance() {
        CinemasFragment fragment = new CinemasFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cinemas, container, false);

        setViews();
        recyclerView = view.findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        CinemasRecyclerViewAdapter adapter = new CinemasRecyclerViewAdapter(cinemasList, mListener);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }

    private void setViews(){
        if (cinemasList == null || cinemasList.size() == 0) {
            cinemasList = new ArrayList<>();
            Cinemas cinemas1 = new Cinemas("Genesis Cinema", "http://res.cloudinary.com/lanre01" +
                    "/image/upload/v1507370209/avengers_image.png", "07:30 pm", "Sept. 29, 2017");
            Cinemas cinemas2 = new Cinemas("Silverbird Cinemas", "http://res.cloudinary.com/" +
                    "lanre01/image/upload/v1507370205/troy_legacy.png", "05:30 pm", "Sept. 30, 2017");
            Cinemas cinemas3 = new Cinemas("Ozone Cinemas", "http://" +
                    "res.cloudinary.com/lanre01/image/upload/v1507370209/assasin_full.png", "07:00 pm", "Oct. 1, 2017");

            cinemasList.add(cinemas1);
            cinemasList.add(cinemas2);
            cinemasList.add(cinemas3);
            cinemasList.add(cinemas1);
            cinemasList.add(cinemas2);
            cinemasList.add(cinemas3);
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
