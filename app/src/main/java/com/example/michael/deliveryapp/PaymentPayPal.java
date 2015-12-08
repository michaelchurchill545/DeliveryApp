
package com.example.michael.deliveryapp;
/**
 * Created by Patrick Balingit on 12/06/2015.
 *
 * This class allows the implementation of the Paypal SDK to allow Paypal as a form
 * of payment for the application
 *
 * PayPal's SDK was found here https://github.com/paypal/PayPal-Android-SDK
 * and added to this project's libs folder
 *
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import java.math.BigDecimal;


public class PaymentPayPal extends AppCompatActivity {

    private static final String TAG = "paymentdemo";
    /**
     * - Set to PaymentActivity.ENVIRONMENT_PRODUCTION to move real money.
     *
     * - Set to PaymentActivity.ENVIRONMENT_SANDBOX to use your test credentials
     * from https://developer.paypal.com
     *
     * - Set to PayPalConfiguration.ENVIRONMENT_NO_NETWORK to kick the tires
     * without communicating to PayPal's servers.
     *
     * I used the PaymentActivity.SANDBOX in conjuction with the PayPalConfiguration method to make a new Payment Acitvity
     */
    private static final String CONFIG_CLIENT_ID = "ARQZaPrIfiz1u8Q_5MDPT3l8yIuazTjmAYB6_msXKNmjeNPQCgEnMJaPZzAv_OCTlNTfO9Btl6wuHGKb";
    // PayPalConfiguration.ENVIRONMENT_NO_NETWORK =
    private static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_SANDBOX;
    private static final int REQUEST_CODE_PAYMENT = 1;
    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(CONFIG_ENVIRONMENT)
            .clientId(CONFIG_CLIENT_ID);
    PayPalPayment thingToBuy;



    /**
     * This OnCreate method makes the Paypal instance that is also saved in the background.
     * with a new button thats allows when pressed that will move to the Paypal Sandbox Screen.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_pay_pal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);
        findViewById(R.id.order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PayPalPayment thingToBuy = new PayPalPayment(new BigDecimal("10.43"), "USD",
                        "Cheese Pizza", PayPalPayment.PAYMENT_INTENT_SALE);
                Intent intent = new Intent(PaymentPayPal.this,
                        PaymentActivity.class);
                intent.putExtra(PaymentActivity.EXTRA_PAYMENT, thingToBuy);
                startActivityForResult(intent, REQUEST_CODE_PAYMENT);
            }
        });


    }
    @Override
    public void onDestroy() {
// Stop service when done
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }




}
