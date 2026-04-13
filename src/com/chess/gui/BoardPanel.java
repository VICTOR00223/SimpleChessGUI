package com.chess.gui;

import com.chess.engine.Game;

import javax.swing.*;

public class BoardPanel extends JPanel
{
    private JButton[][] squares;
    private Game game; // This is the "wire" to the engine

    public BoardPanel(Game game)
    {
        this.game = game; // Now this class can talk to the game!
        this.squares = new JButton[8][8];
    }
}
