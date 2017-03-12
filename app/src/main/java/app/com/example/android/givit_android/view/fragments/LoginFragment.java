package app.com.example.android.givit_android.view.fragments;

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

import app.com.example.android.givit_android.R;
import app.com.example.android.givit_android.models.RegisterResponse;
import app.com.example.android.givit_android.models.UserRegister;
import app.com.example.android.givit_android.net.GivitApi;
import app.com.example.android.givit_android.net.GivitRetrofitService;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {
    @BindView(R.id.userEmail)
    EditText userEmailEditText;
    @BindView(R.id.password)
    EditText passwordEditText;
    @BindView(R.id.long_button)
    Button longButton;
    @BindView(R.id.signUpButton)
    Button signUpButton;
    @BindView(R.id.logInButton)
    Button logInButton;

    private ForgotPasswordListener forgotPasswordListener;
    private int signInStatus = 1;//if user is signing up, equals 1; if user is logging in, equals 0

    public String userEmail;
    public String userPassword;
    public RegisterResponse registerResponse;
    public GivitApi apiDelegate;
    public UserRegister user;
    public Object responseBody;
    public GivitRetrofitService retrofitService = new GivitRetrofitService();
    String code = "1000";
    String message;

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
        signInStatus = 1;

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
        signInStatus = 0;

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

    @OnClick(R.id.long_button)
    public void onClickLongButton() {
        userEmail = userEmailEditText.getText().toString();
        userPassword = passwordEditText.getText().toString();
        user = new UserRegister(userEmail, userPassword);
        System.out.println("USEREMAIL: " + userEmail);
        System.out.println("USERPASSWORD: " + userPassword);

        if (signInStatus == 1) {
            retrofitService.createUser(new Callback<RegisterResponse>() {
                @Override
                public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
//                code = response.body().getCode();
//                message = response.body().getMessage();
                    if (response.body() == null) {
                        System.out.println("NULL CODE");
                    }
                    if (response.body() != null) {
                        code = response.body().getCode();
                    }
                    System.out.println("RESPONSE: " + code);
                }

                @Override
                public void onFailure(Call<RegisterResponse> call, Throwable t) {
                    System.out.println("FAIL CALLBACK");
                    System.out.println("ERROR: " +  t.getLocalizedMessage());
                    System.out.println("ERROR2: " +  t.toString());
                }
            }, user);
        } else {
            retrofitService.signInUser(new Callback<RegisterResponse>() {
                @Override
                public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
//                code = response.body().getCode();
//                message = response.body().getMessage();
                    if (response.body() == null) {
                        System.out.println("NULL CODE");
                    }
                    if (response.body() != null) {
                        code = response.body().getCode();
                        message = response.body().getMessage();
                    }
                    System.out.println("RESPONSE: " + message);
                }

                @Override
                public void onFailure(Call<RegisterResponse> call, Throwable t) {
                    System.out.println("FAIL CALLBACK");
                    System.out.println("ERROR: " +  t.getLocalizedMessage());
                    System.out.println("ERROR2: " +  t.toString());
                }
            }, user);
        }

    }

    public interface ForgotPasswordListener {
        void replaceFragmentListener();
    }
}
