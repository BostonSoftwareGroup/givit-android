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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.com.example.android.givit_android.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment {
    @BindView(R.id.password)
    EditText passwordEditText;
    @BindView(R.id.long_button)
    Button longButton;
    @BindView(R.id.signUpButton)
    Button signUpButton;
    @BindView(R.id.logInButton)
    Button logInButton;

    private ForgotPasswordListener forgotPasswordListener;

    protected View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        this.rootView = view;
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setPasswordHintFont();
        initSignUpButtonLayout();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        forgotPasswordListener = (ForgotPasswordListener) getContext();
    }

    private void setPasswordHintFont() {
        passwordEditText.setTypeface(Typeface.DEFAULT);
        passwordEditText.setTransformationMethod(new PasswordTransformationMethod());
    }

    private void initSignUpButtonLayout() {
        signUpButton.setBackgroundColor(getResources().getColor(R.color.colorMainRed));
        signUpButton.setTextColor(getResources().getColor(R.color.colorWhite));

        logInButton.setTextColor(getResources().getColor(R.color.colorMainRed));
        logInButton.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        logInButton.setBackgroundResource(R.drawable.rigth_half_rect);

        longButton.setBackgroundResource(R.drawable.red_border_rect);
        longButton.setTextColor(getResources().getColor(R.color.colorMainRed));
        longButton.setText(getResources().getString(R.string.signup));
    }

    private void initLogInButtonLayout() {
        logInButton.setBackgroundColor(getResources().getColor(R.color.colorLoginBlue));
        logInButton.setTextColor(getResources().getColor(R.color.colorWhite));

        signUpButton.setTextColor(getResources().getColor(R.color.colorLoginBlue));
        signUpButton.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        signUpButton.setBackgroundResource(R.drawable.left_half_rect);

        longButton.setBackgroundResource(R.drawable.blue_border_rect);
        longButton.setTextColor(getResources().getColor(R.color.colorLoginBlue));
        longButton.setText(getResources().getString(R.string.login));
    }

    @OnClick(R.id.signUpButton)
    public void onClickSignUpButton() {
        initSignUpButtonLayout();
    }

    @OnClick(R.id.logInButton)
    public void onClickLogInButton() {
        initLogInButtonLayout();
    }

    @OnClick(R.id.forgot_password)
    public void onClickForgotPassword() {
        forgotPasswordListener.replaceFragmentListener();
    }

    //test
    @OnClick(R.id.long_button)
    public void onClickLongButton() {
        Toast.makeText(this.getContext(), "Wrong password!", Toast.LENGTH_SHORT).show();
    }

    public interface ForgotPasswordListener {
        void replaceFragmentListener();
    }
}
