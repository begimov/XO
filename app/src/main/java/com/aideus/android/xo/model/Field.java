package com.aideus.android.xo.model;

import android.graphics.Point;

import com.aideus.android.xo.model.exceptions.AlreadyOccupiedException;
import com.aideus.android.xo.model.exceptions.InvalidPointException;

/**
 * Created by Galymzhan Begimov on 26.08.2016.
 */
public class Field {

    private static final int FIELD_SIZE = 3;

    private static final int MIN_COORDINATE = 0;

    private static final int MAX_COORDINATE = FIELD_SIZE;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return field.length;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure)
            throws InvalidPointException, AlreadyOccupiedException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        if (field[point.x][point.y] != null) {
            throw new AlreadyOccupiedException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return (checkCoordinate(point.x) && checkCoordinate(point.y));
    }

    private boolean checkCoordinate(final int coordinate) {
        return (coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE);
    }

}
