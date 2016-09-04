package com.aideus.android.xo.controllers;

import com.aideus.android.xo.data.model.Field;
import com.aideus.android.xo.data.model.Figure;
import com.aideus.android.xo.data.model.Point;
import com.aideus.android.xo.exceptions.AlreadyOccupiedException;
import com.aideus.android.xo.exceptions.InvalidPointException;

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
