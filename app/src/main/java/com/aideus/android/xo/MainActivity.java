package com.aideus.android.xo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aideus.android.xo.controllers.GameController;
import com.aideus.android.xo.model.Field;
import com.aideus.android.xo.model.Figure;
import com.aideus.android.xo.model.Game;
import com.aideus.android.xo.model.Player;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGame();
    }

    private void initGame() {

        final String name1 = "Name1";
        final String name2 = "Name2";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game game = new Game(players, new Field(3), "GameName");

        final GameController gameController = new GameController(game);



    }
}
