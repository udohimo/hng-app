package ng.hotels.android.app.ui.fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import ng.hotels.android.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RequestDialogLoginRegisterFragment extends DialogFragment {


    private OnFragmentInteractionListener mListener;
    private TextView don_t_have;

    public RequestDialogLoginRegisterFragment() {
        // Required empty public constructor
    }

    public interface OnFragmentInteractionListener {
        void onConfirmClicked();
    }


    public static RequestDialogLoginRegisterFragment newInstance() {
        RequestDialogLoginRegisterFragment fragment = new RequestDialogLoginRegisterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View root = inflater.inflate(R.layout.fragment_request_dialog_login_register, null);

        don_t_have = root.findViewById(R.id.don_t_have_);

        don_t_have.setText(Html.fromHtml(getString(R.string.don_t_have_)));

        builder.setView(root);
        final AlertDialog dialog = builder.create();

        dialog.getWindow().setLayout(364,440);

        return dialog;
    }

}
