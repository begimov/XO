package com.aideus.android.xo.controllers;

import com.aideus.android.xo.data.model.Field;
import com.aideus.android.xo.data.model.Figure;
import com.aideus.android.xo.data.model.Point;
import com.aideus.android.xo.exceptions.InvalidPointException;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {

        int countFigure = 0;

        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                try {
                    if (field.getFigure(new Point(i,j)) != null) {
                        countFigure++;
                    }
                } catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        }
        if (countFigure == field.getSize() * field.getSize()) {
            return null;
        } else if (countFigure % 2 == 0){
            return Figure.X;
        } else {
            return Figure.O;
        }
    }

}
