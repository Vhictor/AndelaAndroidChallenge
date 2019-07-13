package ng.com.grazac.andelaandroidchallenge;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class AboutALCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);


        WebView viewALC = findViewById(R.id.webview);
        WebSettings settings = viewALC.getSettings();
        settings.setJavaScriptEnabled(true);

        viewALC.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                //super.onReceivedSslError(view, handler, error);
               handler.proceed();
                Toast.makeText(getApplicationContext(), "Error occurred " + error.getPrimaryError(), Toast.LENGTH_SHORT).show();
            }
        });
        viewALC.loadUrl("https://www.andela.com/alc/");

    }
}
