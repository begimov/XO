package com.aideus.android.xo;

import com.aideus.android.xo.controllers.GameController;
import com.aideus.android.xo.data.model.Field;
import com.aideus.android.xo.data.model.Figure;
import com.aideus.android.xo.data.model.Game;
import com.aideus.android.xo.data.model.Player;
import com.aideus.android.xo.data.model.Point;
import com.aideus.android.xo.exceptions.InvalidPointException;

class GameManager {

    private GameController gameController;

    private Game game;

    void initGame() {

        final String name1 = "Name1";
        final String name2 = "Name2";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        game = new Game(players, new Field(3), "GameName");

        gameController = new GameController(game);

    }

    Game getGame() {
        return game;
    }

    //Methods to save and load game state from Db (using DataManager)

    //Method to clean game save from Db (using DataManager)

}
