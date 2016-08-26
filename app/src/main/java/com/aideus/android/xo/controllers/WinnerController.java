package com.aideus.android.xo.controllers;

import com.aideus.android.xo.model.Field;
import com.aideus.android.xo.model.Figure;
import com.aideus.android.xo.model.Point;
import com.aideus.android.xo.model.exceptions.InvalidPointException;

/**
 * Created by Galymzhan Begimov on 26.08.2016.
 */

public class WinnerController {

    public Figure getWinner(final Field field) {

        try {
            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(i, 0), new IPointGenerator() {
                    @Override
                    public Point next(Point point) {
                        return new Point(point.getX(), point.getY() + 1);
                    }
                })) {
                    return field.getFigure(new Point(i, 0));
                }
            }
            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(0, i), new IPointGenerator() {
                    @Override
                    public Point next(Point point) {
                        return new Point(point.getX() + 1, point.getY());
                    }
                })) {
                    return field.getFigure(new Point(0, i));
                }
            }
            if (check(field, new Point(0, 0), new IPointGenerator() {
                @Override
                public Point next(Point point) {
                    return new Point(point.getX() + 1,  point.getY() + 1);
                }
            })) {
                return field.getFigure(new Point(0, 0));
            }
            if (check(field, new Point(0, 2), new IPointGenerator() {
                @Override
                public Point next(Point point) {
                    return new Point(point.getX() + 1, point.getY() - 1);
                }
            })) {
                return field.getFigure(new Point(1, 1));
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field, final Point currentPoint, final IPointGenerator pointGenerator) {

        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }

        if (currentFigure == null) return false;

        if (currentFigure != nextFigure) return false;

        return check(field, nextPoint, pointGenerator);
    }

    private interface IPointGenerator {
        Point next(final Point point);
    }

}
