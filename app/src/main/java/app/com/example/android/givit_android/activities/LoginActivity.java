package app.com.example.android.givit_android.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import app.com.example.android.givit_android.R;
import app.com.example.android.givit_android.fragments.LoginFragment;
import app.com.example.android.givit_android.fragments.ResetPasswordFragment;

public class LoginActivity extends AppCompatActivity implements LoginFragment.ForgotPasswordListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setActionbar();
        replaceFragment(R.id.login_fragment, new LoginFragment(), true);
    }

    private void setActionbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    private void replaceFragment(int layout, Fragment newFragment, boolean isFirstFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
        if (isFirstFragment) {
            fragmentTransaction.add(layout, newFragment);
        } else {
            fragmentTransaction.replace(layout, newFragment);
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void replaceFragmentListener() {
        replaceFragment(R.id.login_fragment, new ResetPasswordFragment(), false);
    }
}
