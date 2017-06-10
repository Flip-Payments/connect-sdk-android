package com.flip.connect.presentation.base;

/**
 * Created by jcosilva on 6/9/2017.
 */

public class NotAttachedException extends RuntimeException {

    public NotAttachedException() {
        super("View not attached");
    }

}
