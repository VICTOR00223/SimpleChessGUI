package com.chess.gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import com.chess.engine.Game;

public class ChessFrame extends JFrame
{
    public ChessFrame(Game game)
    {
        // 1. Basic Window Settings
        setTitle("Chess Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Stops the program when 'X' is clicked
        setSize(800, 800); // A good size for a square board
        setLayout(new BorderLayout()); // Helps us put the board in the center
        setLocationRelativeTo(null); // Centers the window on your screen

        // 2. This is where we will eventually add the BoardPanel
        // For now, it's just an empty shell

        // 3. Make it visible
        setVisible(true);
    }
}
