package com.kostandinangjellari.kalah.exceptions;

import com.kostandinangjellari.kalah.constants.GameStrings;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/17/2015.
 * Copyright 2015
 */
public class InvalidMoveException extends Exception {

    public InvalidMoveException() {
        super( GameStrings.INVALID_MOVE_EXCEPTION);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
