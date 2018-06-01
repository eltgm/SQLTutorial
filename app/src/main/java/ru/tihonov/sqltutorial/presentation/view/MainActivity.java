package ru.tihonov.sqltutorial.presentation.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.tihonov.sqltutorial.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showUnits();
        /*String htmlAsString = "<html><body><h1>Hello, world</h1></body></html>";
        webView.loadDataWithBaseURL(null, htmlAsString, "text/html", "utf-8", null);*/
    }

    private void showUnits() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flMain, new UnitsFragment())
                .commit();
    }
}
