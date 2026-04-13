package com.chess.gui;

import com.chess.engine.Game;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel
{
    private JButton[][] squares = new JButton[8][8];
    private Game game; // This is the "wire" to the engine

    public BoardPanel(Game game)
    {
        this.game = game; // Now this class can talk to the game!

    }

    private void initializeSquares()
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                JButton button = new JButton();

                // Set the coordinate tag
                button.setActionCommand(i + "," + j);

                // Color the square
                if ((i + j) % 2 == 0)
                {
                    button.setBackground(Color.WHITE);
                } else
                {
                    button.setBackground(Color.GRAY);
                }

                // Add the "Ear" to listen for clicks
                button.addActionListener(e -> {
                    System.out.println("User clicks the button at " + e.getActionCommand());
                });
            }
        }
    }
}
