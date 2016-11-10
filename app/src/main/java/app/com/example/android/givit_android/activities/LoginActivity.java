package app.com.example.android.givit_android.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import app.com.example.android.givit_android.R;
import app.com.example.android.givit_android.fragments.LoginFragment;
import app.com.example.android.givit_android.fragments.ResetPasswordFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        replaceFragment(R.id.login_fragment, new LoginFragment(), true);
    }

    private void replaceFragment(int layout, Fragment newFragment, boolean isFirstFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (isFirstFragment) {
            fragmentTransaction.add(layout, newFragment);
        } else {
            fragmentTransaction.replace(layout, newFragment);
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
