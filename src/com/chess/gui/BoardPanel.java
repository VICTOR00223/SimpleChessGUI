package com.chess.gui;

import com.chess.engine.Game;
import com.chess.model.Piece;
import com.chess.model.Position;
import com.chess.model.Side;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel
{
    private JButton[][] squares = new JButton[8][8];
    private Game game; // This is the "wire" to the engine
    private Position click1 = null;
    private ChessFrame frame;

    public BoardPanel(ChessFrame frame)
    {
        this.frame = frame;//This exists to be able to change the title at the end of the game
        this.game = new Game(); // Now this class can talk to the game!
        this.setLayout(new GridLayout(8, 8));//So the window has 64 spaces for the buttons
        initializeSquares();// makes the visual board with each cell having a button
        updateBoard();//refreshes color and gives the icons of the pieces
    }

    private void initializeSquares()
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                JButton button = new JButton();//each square has it's button object
                Position buttonPos = new Position(i, j);

                //Set size and font for text
                button.setFont(new Font("SansSerif", Font.PLAIN, 60));
                // Color the square
                if ((i + j) % 2 == 0)
                {
                    button.setBackground(Color.WHITE);
                }
                else
                {
                    button.setBackground(Color.GRAY);
                }

                // Add the "Ear" to listen for clicks
                button.addActionListener(e -> {
                    handleButtonClick(buttonPos);
                });//if clicked will give the command string from setActionCommand

                // Store and Add
                this.squares[i][j] = button;
                this.add(button);
            }
        }
    }

    private void handleButtonClick(Position position)
    {
        //1. Check if the game is already over
        if (!this.game.isGameActive())
        {
            return; // Exit the method immediately; do nothing!
        }

        //2. Check if this is the 1st mouse click
        if(this.click1 == null)
        {
            //2.1. Check if the user actually selected a position with a piece
            if (this.game.getPiece(position) != null)
            {
                this.click1 = position;
                // Highlight the selection
                this.squares[position.getRow()][position.getCol()].setBackground(Color.YELLOW);
            }
        }
        else//3. Check if this is the 2nd click
        {
            //3.1. Check if the move is valid
            if(this.game.isMoveLegal(click1, position))
            {
                //3.2 Execute the move
                this.game.MakeMove(click1, position);//The turn switches

                //3.3 Check the state of the game:
                if(!this.game.isGameActive())
                {
                    //Announce the winner
                    String winner = (this.game.getOppositeTurn() == Side.WHITE) ? "White" : "Black";
                    this.frame.updateStatus("Game Over! " + winner + " won!");
                }
                else
                {
                    // Normal move: update turn message
                    String turn = (this.game.getCurrentTurn() == Side.WHITE) ? "White's Turn" : "Black's Turn";
                    this.frame.updateStatus(turn);
                }
            }

            //Cleanup
            this.click1 = null;
            updateBoard();
        }
    }

    public void updateBoard()
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                Piece p = this.game.getPiece(new Position(i, j));

                // 1. Updates the Icon
                this.squares[i][j].setText(p != null ? p.getIcon() : "");

                // 2. Update the Color (The "Automatic Reset")
                if ((i + j) % 2 == 0)
                {
                    this.squares[i][j].setBackground(Color.WHITE);
                } else
                {
                    this.squares[i][j].setBackground(Color.GRAY);
                }
            }
        }
    }
}
