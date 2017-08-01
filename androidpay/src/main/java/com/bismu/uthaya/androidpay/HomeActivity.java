package com.bismu.uthaya.androidpay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.Purchase;
import com.bismu.uthaya.androidpay.billing.BillingManager;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Uthaya on 1/8/17.
 */

public class HomeActivity {
    private static BillingManager mBillingManager;
    InAPPBillingSetup mViewController;
    Activity activity;


    public HomeActivity(Activity activity, String SKU_ID, String BASE_64_ENCODED) {
        this.activity = activity;
        mViewController = new InAPPBillingSetup(this, SKU_ID);
        initBillingManager(activity, SKU_ID, BASE_64_ENCODED);
    }

    public void initBillingManager(Activity activity, String SKU_ID, String BASE_64_ENCODED) {
        // Create and initialize BillingManager which talks to BillingLibrary
        if (mBillingManager == null)
            mBillingManager = new BillingManager(activity, mViewController.getUpdateListener(), BASE_64_ENCODED);
        mBillingManager.initiatePurchaseFlow(SKU_ID, BillingClient.SkuType.INAPP);

    }

    public void onPurchasesUpdated(List<Purchase> purchaseList) {
        Intent resultIntent = new Intent();
        Bundle args = new Bundle();
        args.putSerializable("result", (Serializable) purchaseList);
        resultIntent.putExtra("PurchaseBundle", args);
        activity.setResult(Activity.RESULT_OK, resultIntent);
        activity.finish();
    }

}
