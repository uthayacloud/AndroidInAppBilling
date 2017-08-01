package com.bismu.uthaya.androidpay;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class HomeActivity {
    Activity activity;

    public HomeActivity (Activity activity) {
        this.activity = activity;
    }

    public void showToast(String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();

    }
}
