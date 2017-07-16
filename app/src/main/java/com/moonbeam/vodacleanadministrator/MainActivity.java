package com.moonbeam.vodacleanadministrator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView web;
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web=(WebView)findViewById(R.id.web);
        web.setWebViewClient(new WebViewClient());
        web.setWebChromeClient(new WebChromeClient());
        WebSettings settings = web.getSettings();
        settings.setSavePassword(true);
        settings.setSaveFormData(true);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setDomStorageEnabled(true);
        settings.setSupportMultipleWindows(true);
        web.loadUrl("https://vodacleanserver3893.000webhostapp.com");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater om=getMenuInflater();
        om.inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.reload:
                web.loadUrl("https://vodacleanserver3893.000webhostapp.com");
                break;
            case R.id.about:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("Created by-");
                dialog.setMessage("\tLovely Singh\n\t11211636");
                dialog.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                break;
            case R.id.exit:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finish();
            moveTaskToBack(true);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
