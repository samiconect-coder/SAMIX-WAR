package dz.samix.war;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.view.View;
import android.graphics.Color;

public class MainActivity extends Activity {
    private WebView web;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        getWindow().setStatusBarColor(Color.rgb(5, 17, 25));
        getWindow().setNavigationBarColor(Color.rgb(5, 17, 25));

        getWindow().getDecorView().setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_FULLSCREEN |
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );

        web = new WebView(this);
        web.setBackgroundColor(Color.rgb(5, 17, 25));

        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);

        web.setWebChromeClient(new WebChromeClient());
        setContentView(web);

        web.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void onBackPressed() {
        if (web != null) {
            web.evaluateJavascript("showHomeFromAndroid()", null);
        } else {
            super.onBackPressed();
        }
    }
}