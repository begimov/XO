package com.aideus.android.xo.model;

import android.graphics.Point;

/**
 * Created by Galymzhan Begimov on 26.08.2016.
 */
public class Field {

    private static final int FIELD_SIZE = 3;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return field.length;
    }

    public Figure getFigure(final Point point) {
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) {
        field[point.x][point.y] = figure;
    }

}
