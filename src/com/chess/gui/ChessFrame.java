package com.chess.gui;

import javax.swing.*;
import java.awt.BorderLayout;
import com.chess.engine.Game;

public class ChessFrame extends JFrame
{
    private BoardPanel boardPanel;
    private JLabel statusLabel;

    public ChessFrame()
    {
        // 1. Basic Window Setup
        this.setTitle("Chess Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());//It is needed to put the title in the north, the board in the center

        // 2. The Announcer
        this.statusLabel = new JLabel("White's Turn", SwingConstants.CENTER);
        this.add(this.statusLabel, BorderLayout.NORTH);

        // 2. Create the Board and "Plug in" this frame
        this.boardPanel = new BoardPanel(this);//connects the boardpanel with the frame

        // 3. Add the board to the window
        this.add(this.boardPanel, BorderLayout.CENTER);//connects the frame with the boardpanel and put's it in the middle

        // 4. Finalize visual appearance
        this.pack(); // Adjusts window size to fit the 8x8 grid perfectly
        this.setLocationRelativeTo(null); // Centers the window on your screen
        this.setVisible(true);
    }

    public void updateStatus(String message)
    {
        this.statusLabel.setText(message);
    }
}
