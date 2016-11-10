package app.com.example.android.givit_android.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import app.com.example.android.givit_android.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment {
    @BindView(R.id.password)
    EditText passwordEditText;

    private ForgotPasswordListener forgotPasswordListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setPasswordHintFont();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        forgotPasswordListener = (ForgotPasswordListener)getContext();
    }

    private void setPasswordHintFont() {
        passwordEditText.setTypeface(Typeface.DEFAULT);
        passwordEditText.setTransformationMethod(new PasswordTransformationMethod());
    }

    @OnClick(R.id.forgot_password)
    public void onClickForgotPassword() {
        forgotPasswordListener.replaceFragmentListener();
    }

    public interface ForgotPasswordListener {
        void replaceFragmentListener();
    }
}
