package com.github.vipulasri.timeline;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewFragment extends Fragment {

    private String currentURL;
    private String googleURL = "https://www.google.com";
    private String presentationURL = "https://clearvoice.meeamitech.com/huddl/presentation.html";
    private String salesforceURL = "https://app.drastin.com/#/query/f11c81c24d0d4229928e97e2d495f4ab/";


    public void init(String url) {
        currentURL = url;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("SwA", "WVF onCreateView");
        View v = inflater.inflate(R.layout.webview_layout, container, false);
        init(presentationURL);
        if (currentURL != null) {
            Log.d("SwA", "Current URL 1["+currentURL+"]");

            WebView wv = (WebView) v.findViewById(R.id.webview);
            wv.getSettings().setJavaScriptEnabled(true);
            wv.getSettings().setPluginState(WebSettings.PluginState.ON);
            wv.getSettings().setBuiltInZoomControls(false);
            wv.getSettings().setSupportZoom(false);
            wv.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            wv.getSettings().setAllowFileAccess(true);
            wv.getSettings().setDomStorageEnabled(true);
            wv.loadUrl(googleURL);
        }
        return v;
    }
}
