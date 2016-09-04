package com.aideus.android.xo.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aideus.android.xo.R;

import java.util.Arrays;

public class GameScreenFragment extends Fragment {

    private static final String ARG_FIELD = "fieldArray";

    private OnFragmentInteractionListener mListener;

    private TextView textView;

    public GameScreenFragment() {
        // Required empty public constructor
    }

    public static GameScreenFragment newInstance() {
        GameScreenFragment fragment = new GameScreenFragment();
        Bundle args = new Bundle();
//        args.putStringArray(ARG_FIELD, field);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mFieldString = getArguments().getStringArray(ARG_FIELD);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_screen, container, false);
        textView = (TextView) view.findViewById(R.id.tv_game);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onCellFieldPressed (int x, int y) {
        if (mListener != null) {
            mListener.onGameScreenFragmentInteraction(x, y);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void showField(final String[] mFieldString, final int fieldSize) {
        //Get screen size in pixels

        //Show board with fieldSize * fieldSize number of cells
        showBoard(fieldSize);

        //Populate board with figures
        showFigures(mFieldString, fieldSize);
    }

    private void showBoard(final int boardSize) {
        textView.setText(String.valueOf(boardSize * boardSize));
    }

    private void showFigures(final String[] mFieldString, final int fieldSize) {
        textView.setText(Arrays.toString(mFieldString));
    }

    public interface OnFragmentInteractionListener {
        void onGameScreenFragmentInteraction(int x, int y);
    }
}
