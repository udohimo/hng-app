package ng.hotels.android.app.ui.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import ng.hotels.android.app.R;

/**
 * Created by abdulrahman on 10/8/17.
 */

public class SlowNetworkOptionsFragment extends DialogFragment {

    private OnFragmentInteractionListener mListener;


    public static SlowNetworkOptionsFragment newInstance(){
        return new SlowNetworkOptionsFragment();
    }
    public SlowNetworkOptionsFragment(){

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View root = inflater.inflate(R.layout.fragment_slow_network_options, null);

        Button slowNetwork = root.findViewById(R.id.low_network_button);
        Button highNetwork = root.findViewById(R.id.high_network_button);

        builder.setView(root);
        final AlertDialog dialog = builder.create();

        slowNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        highNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        return dialog;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener){
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

    public interface OnFragmentInteractionListener{
        void onFragmentInteraction();
    }
}
