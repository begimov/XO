package com.aideus.android.xo.controllers;

import com.aideus.android.xo.model.Field;
import com.aideus.android.xo.model.Figure;
import com.aideus.android.xo.model.Point;
import com.aideus.android.xo.model.exceptions.AlreadyOccupiedException;
import com.aideus.android.xo.model.exceptions.InvalidPointException;

/**
 * Created by Galymzhan Begimov on 26.08.2016.
 */

public class MoveController {

    public void applyFigure(final Field field,
                            final Figure figure,
                            final Point point)
            throws InvalidPointException, AlreadyOccupiedException {

        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }

        field.setFigure(point, figure);

    }

}
