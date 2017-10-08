package ng.hotels.android.app.ui.fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import ng.hotels.android.app.R;


public class PendingPaymentReminderFragment extends DialogFragment {


    private OnFragmentInteractionListener mListener;

    public PendingPaymentReminderFragment() {
        // Required empty public constructor
    }

    public interface OnFragmentInteractionListener {
        void onConfirmClicked();
    }


    public static PendingPaymentReminderFragment newInstance() {
        PendingPaymentReminderFragment fragment = new PendingPaymentReminderFragment();
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

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View root = inflater.inflate(R.layout.fragment_pending_payment_reminder, null);

        final Button payNow = root.findViewById(R.id.pay_now_button);
        final Button payLater = root.findViewById(R.id.pay_later_button);

        builder.setView(root);
        final AlertDialog dialog = builder.create();

        payNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onConfirmClicked();
                dialog.dismiss();
            }
        });

        payLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        return dialog;
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

}