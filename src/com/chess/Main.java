package com.chess;


import com.chess.gui.ChessFrame;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            new ChessFrame();
        });
    }
}
