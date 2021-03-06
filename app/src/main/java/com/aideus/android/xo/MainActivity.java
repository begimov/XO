package com.aideus.android.xo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aideus.android.xo.view.fragments.GameScreenFragment;

public class MainActivity extends AppCompatActivity implements GameScreenFragment.OnFragmentInteractionListener {

    private GameScreenFragment gameScreenFragment;

    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //TODO Display GameSettingsFragment
        //Get game properties from user in GameSettingsFragment
        //Send game properties to GameManager

        gameManager = new GameManager();
        gameManager.initGame();

        //Display GameScreenFragment

        gameScreenFragment = GameScreenFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, gameScreenFragment)
                .commit();

    }

    @Override
    protected void onResume() {

        super.onResume();

        //Get Game from GameManager and display it

        gameScreenFragment.showField(gameManager.getGame());

        //TODO Load game progress using GameManager->DataManager

    }

    @Override
    protected void onPause() {
        //TODO Save game progress using GameManager->DataManager
        super.onPause();
    }

    //Assign callback onClick listener methods to get clicked position from GameScreenFragment

    @Override
    public void onGameScreenFragmentInteraction(int x, int y) {

        //For every received click coordinate send it to GameManager

        //Get confirmation that move applied, and tell GameScreenFragment to display it
        // (get Player which move is it and which figure to display), or get move rejection and tell GameScreenFragment to react (everything from GameManager)

        //Get confirmation for winner if there is one from GameManager and tell GameScreenFragment to react to it
        // After that get callback and restart game by showing GameSettingsFragment

        //Get confirmation for draw if there is one from GameManager and tell GameScreenFragment to react to it
        // After that get callback and restart game by showing GameSettingsFragment
    }
}
