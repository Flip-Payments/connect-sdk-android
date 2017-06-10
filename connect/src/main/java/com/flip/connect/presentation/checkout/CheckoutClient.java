package com.flip.connect.presentation.checkout;

import com.flip.connect.domain.boundary.CheckoutCallback;
import com.flip.connect.presentation.base.BaseWebClient;

/**
 * Created by JGabrielFreitas on 18/04/17.
 */

public class CheckoutClient extends BaseWebClient {

    private CheckoutCallback checkoutCallback;

    public CheckoutClient(CheckoutCallback checkoutCallback) {
        this.checkoutCallback = checkoutCallback;
    }
}
