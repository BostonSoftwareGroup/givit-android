package app.com.example.android.givit_android.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.com.example.android.givit_android.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetPasswordFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reset_password, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.reset_back_arrow_button)
    public void onResetBackPressed() {
        getFragmentManager().popBackStack();
    }
}
