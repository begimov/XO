package com.aideus.android.xo.controllers;

import com.aideus.android.xo.data.model.Field;
import com.aideus.android.xo.data.model.Figure;
import com.aideus.android.xo.data.model.Game;
import com.aideus.android.xo.data.model.Point;
import com.aideus.android.xo.exceptions.AlreadyOccupiedException;
import com.aideus.android.xo.exceptions.InvalidPointException;

public class GameController {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    private final Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public boolean move(final Point point) {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.format("Winner: %s\n", winner);
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.println("No winner and no moves left");
            return false;
        }
        try {
            moveController.applyFigure(field, currentFigure, point);
        } catch (final InvalidPointException | AlreadyOccupiedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
