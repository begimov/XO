package com.aideus.android.xo.controllers;

import android.util.Log;

import com.aideus.android.xo.model.Field;
import com.aideus.android.xo.model.Figure;
import com.aideus.android.xo.model.Point;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class WinnerControllerTest {
    @Test
    public void testGetWinnerWhenWinnerRow() throws Exception {

        final WinnerController winnerController = new WinnerController();

        final Random random = new Random();
        final int fieldSize = random.nextInt(100) + 3;

        System.out.print(Integer.toString(fieldSize));

        for (int i = 0; i < fieldSize; i++) {
            final Field field = new Field(fieldSize);
            for (int j = 0; j < fieldSize; j++) {
                field.setFigure(new Point(i, j), Figure.X);
            }
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerRow() throws Exception {

        final WinnerController winnerController = new WinnerController();

        final Random random = new Random();
        final int fieldSize = random.nextInt(100) + 3;

        System.out.print(Integer.toString(fieldSize));

        for (int i = 0; i < fieldSize; i++) {
            final Field field = new Field(fieldSize);
            for (int j = 0; j < fieldSize; j++) {
                if (j == fieldSize - 1) {
                    field.setFigure(new Point(i, j), Figure.O);
                } else {
                    field.setFigure(new Point(i, j), Figure.X);
                }
            }
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerColumn() throws Exception {

        final WinnerController winnerController = new WinnerController();

        final Random random = new Random();
        final int fieldSize = random.nextInt(100) + 3;

        System.out.print(Integer.toString(fieldSize));

        for (int i = 0; i < fieldSize; i++) {
            final Field field = new Field(fieldSize);
            for (int j = 0; j < fieldSize; j++) {
                field.setFigure(new Point(j, i), Figure.X);
            }
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerColumn() throws Exception {

        final WinnerController winnerController = new WinnerController();

        final Random random = new Random();
        final int fieldSize = random.nextInt(100) + 3;

        System.out.print(Integer.toString(fieldSize));

        for (int i = 0; i < fieldSize; i++) {
            final Field field = new Field(fieldSize);
            for (int j = 0; j < fieldSize; j++) {
                if (j == fieldSize - 1) {
                    field.setFigure(new Point(j, i), Figure.X);
                } else {
                    field.setFigure(new Point(j, i), Figure.O);
                }
            }
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerDiag1() throws Exception {

        final WinnerController winnerController = new WinnerController();

        final Random random = new Random();
        final int fieldSize = random.nextInt(100) + 3;

        System.out.print(Integer.toString(fieldSize));

        final Field field = new Field(fieldSize);

        for (int i = 0; i < fieldSize; i++) {
                field.setFigure(new Point(i, i), Figure.X);
        }
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenNoWinnerDiag1() throws Exception {

        final WinnerController winnerController = new WinnerController();

        final Random random = new Random();
        final int fieldSize = random.nextInt(100) + 3;

        System.out.print(Integer.toString(fieldSize));

        final Field field = new Field(fieldSize);

        for (int i = 0; i < fieldSize; i++) {
            if (i == fieldSize - 1) {
                field.setFigure(new Point(i, i), Figure.O);
            } else {
                field.setFigure(new Point(i, i), Figure.X);
            }
        }
        assertNull(winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenWinnerDiag2() throws Exception {

        final WinnerController winnerController = new WinnerController();

        final Random random = new Random();
        final int fieldSize = random.nextInt(100) + 3;

        System.out.print(Integer.toString(fieldSize));

        final Field field = new Field(fieldSize);

        for (int i = 0; i < fieldSize; i++) {
            field.setFigure(new Point(i, fieldSize - (i + 1)), Figure.X);
        }
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenNoWinnerDiag2() throws Exception {

        final WinnerController winnerController = new WinnerController();

        final Random random = new Random();
        final int fieldSize = random.nextInt(100) + 3;

        System.out.print(Integer.toString(fieldSize));

        final Field field = new Field(fieldSize);

        for (int i = 0; i < fieldSize; i++) {
            if (i == fieldSize - 1) {
                field.setFigure(new Point(i, fieldSize - (i + 1)), Figure.O);
            } else {
                field.setFigure(new Point(i, fieldSize - (i + 1)), Figure.X);
            }
        }
        assertNull(winnerController.getWinner(field));
    }
}