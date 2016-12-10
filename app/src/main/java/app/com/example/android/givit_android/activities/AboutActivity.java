package app.com.example.android.givit_android.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import app.com.example.android.givit_android.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity {
    @BindView(R.id.about_givit)
    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        fitWebsite();
    }

    private void fitWebsite() {
        browser.loadUrl("http://www.bostonsoftwaregroup.org");
    }
}
