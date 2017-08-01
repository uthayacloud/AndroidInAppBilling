package com.bismu.uthaya.androidpay;

import android.util.Log;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.Purchase;
import com.bismu.uthaya.androidpay.billing.BillingManager.BillingUpdatesListener;

import java.util.List;

public class InAPPBillingSetup {
    private static final String TAG = "MainViewController";

    private final UpdateListener mUpdateListener;
    private HomeActivity mActivity;
    private String SKU_ID;

    private boolean mBestOfGuide;

    public InAPPBillingSetup(HomeActivity activity, String SKU_ID) {
        mUpdateListener = new UpdateListener();
        mActivity = activity;
        this.SKU_ID = SKU_ID;
    }

    public boolean isBestOfGuideMonthlySubscribed() {
        return mBestOfGuide;
    }

    public UpdateListener getUpdateListener() {
        return mUpdateListener;
    }

    /**
     * Handler to billing updates
     */
    private class UpdateListener implements BillingUpdatesListener {
        @Override
        public void onBillingClientSetupFinished() {
//            mContext.onBillingManagerSetupFinished();
        }

        @Override
        public void onConsumeFinished(String token, @BillingClient.BillingResponse int result) {
            Log.d(TAG, "Consumption finished. Purchase token: " + token + ", result: " + result);

            // Note: We know this is the SKU_GAS, because it's the only one we consume, so we don't
            // check if token corresponding to the expected sku was consumed.
            // If you have more than one sku, you probably need to validate that the token matches
            // the SKU you expect.
            // It could be done by maintaining a map (updating it every time you call consumeAsync)
            // of all tokens into SKUs which were scheduled to be consumed and then looking through
            // it here to check which SKU corresponds to a consumed token.
            if (result == BillingClient.BillingResponse.OK) {
                // Successfully consumed, so we apply the effects of the item in our
                // game world's logic, which in our case means filling the gas tank a bit
                Log.d(TAG, "Consumption successful. Provisioning.");
            } else {
            }

            Log.d(TAG, "End consumption flow.");
        }

        @Override
        public void onPurchasesUpdated(List<Purchase> purchaseList) {
            mBestOfGuide = false;

            for (Purchase purchase : purchaseList) {
                if (purchase.getSku() == SKU_ID) {
                    mBestOfGuide = true;
                    mActivity.onPurchasesUpdated(purchaseList);
                    break;
                }
            }
        }
    }
}
