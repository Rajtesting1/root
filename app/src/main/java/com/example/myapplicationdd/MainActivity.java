package com.example.myapplicationdd;

import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.scottyab.rootbeer.RootBeer;
import com.scottyab.rootbeer.util.Utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RootBeer rootBeer = new RootBeer(MainActivity.this);

    public static native String baseUrlFromJNI();


    static {
        System.loadLibrary("toolChecker");
    }

    public static String getInstance() {
        return baseUrlFromJNI();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String mVal= getInstance();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Toast.makeText(MainActivity.this,mVal, Toast.LENGTH_LONG).show();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
//|| !Utils.isSelinuxFlagInEnabled()
                if (rootBeer.detectRootManagementApps() || rootBeer.detectPotentiallyDangerousApps() || rootBeer.detectRootCloakingApps() || rootBeer.detectTestKeys() || rootBeer.checkForBusyBoxBinary() || rootBeer.checkForSuBinary() || rootBeer.checkSuExists() || rootBeer.checkForRWPaths() || rootBeer.checkForDangerousProps() || rootBeer.checkForRootNative()  || rootBeer.checkForMagiskBinary() || rootBeer.checkForMagiskNative() ||  rootBeer.checkForRootNative() || rootBeer.checkForMagiskBinary() ) {
                    Toast.makeText(MainActivity.this, "Rooted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Not Rooted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}