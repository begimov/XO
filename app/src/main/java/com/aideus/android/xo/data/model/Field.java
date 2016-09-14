package com.aideus.android.xo.data.model;

import com.aideus.android.xo.exceptions.InvalidPointException;

public class Field {

    private static final int MIN_COORDINATE = 0;

    private final Figure[][] field;

    private final int fieldSize;

    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }

    public int getSize() {
        return fieldSize;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final Figure figure)
            throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        field[point.getX()][point.getY()] = figure;
    }

    //TODO Temporary method for testing of showing board, use show figure by figure (getFigure) instead
    public Figure[][] getField() {
        return field;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.getX(), field.length)
                && checkCoordinate(point.getY(), field[point.getX()].length);
    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }

}
