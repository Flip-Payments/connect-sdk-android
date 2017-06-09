package com.flip.connect.domain.boundary;

import com.flip.connect.data.model.checkout.Transaction;

/**
 * Created by JGabrielFreitas on 17/04/17.
 */

public interface CheckoutGrabber {

  Transaction getTransaction();

}
