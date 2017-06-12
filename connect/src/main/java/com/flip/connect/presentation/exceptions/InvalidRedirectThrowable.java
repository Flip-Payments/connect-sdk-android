package com.flip.connect.presentation.exceptions;

/**
 * Created by jcosilva on 6/12/2017.
 */

public class InvalidRedirectThrowable extends Throwable {
    public InvalidRedirectThrowable(){
        super("Invalid redirect. Check your schema and host");
    }
}
