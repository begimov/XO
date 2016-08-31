package com.aideus.android.xo.controllers;

import com.aideus.android.xo.model.Field;
import com.aideus.android.xo.model.Figure;
import com.aideus.android.xo.model.Point;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CurrentMoveControllerTest {
    @Test
    public void testCurrentMoveWhenNextIsO() throws Exception {

        final Random random = new Random();
        final int fieldSize = random.nextInt(100) + 3;

        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(fieldSize);

        System.out.print(Integer.toString(fieldSize));

        //TODO Populate random field according to the test
        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(0,1), Figure.O);
        field.setFigure(new Point(0,2), Figure.X);

        assertEquals(Figure.O, currentMoveController.currentMove(field));
    }

    @Test
    public void testCurrentMoveWhenNextIsX() throws Exception {

        final Random random = new Random();
        final int fieldSize = random.nextInt(100) + 3;

        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(fieldSize);

        System.out.print(Integer.toString(fieldSize));

        //TODO Populate random field according to the test
        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(0,1), Figure.O);

        assertEquals(Figure.X, currentMoveController.currentMove(field));
    }

    @Test
    public void testCurrentMoveWhenNextIsNone() throws Exception {

        final Random random = new Random();
        final int fieldSize = random.nextInt(100) + 3;

        final CurrentMoveController currentMoveController = new CurrentMoveController();

        //TODO Create field with fieldSize
        final Field field = new Field(3);

        System.out.print(Integer.toString(fieldSize));

        //TODO Populate random field according to the test
        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(0,1), Figure.O);
        field.setFigure(new Point(0,2), Figure.X);
        field.setFigure(new Point(1,0), Figure.O);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(1,2), Figure.O);
        field.setFigure(new Point(2,0), Figure.X);
        field.setFigure(new Point(2,1), Figure.O);
        field.setFigure(new Point(2,2), Figure.X);

        assertNull(currentMoveController.currentMove(field));
    }

}