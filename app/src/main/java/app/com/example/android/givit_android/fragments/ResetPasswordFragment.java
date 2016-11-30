package app.com.example.android.givit_android.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import app.com.example.android.givit_android.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetPasswordFragment extends Fragment {
    @BindView(R.id.send_email_button)
    Button sendEmailButton;

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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setButtonBorder();
    }

    private void setButtonBorder() {
        sendEmailButton.setBackgroundResource(R.drawable.red_border_rect);
    }

    @OnClick(R.id.reset_back_arrow_button)
    public void onResetBackPressed() {
        getFragmentManager().popBackStack();
    }
}
