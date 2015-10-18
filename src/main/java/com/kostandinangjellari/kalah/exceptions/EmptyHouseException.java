package com.kostandinangjellari.kalah.exceptions;

import com.kostandinangjellari.kalah.constants.GameStrings;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/17/2015.
 * Copyright 2015
 */

public class EmptyHouseException extends Exception {

    public EmptyHouseException() {
        super(GameStrings.EMPTY_HOUSE_EXCEPTION);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
