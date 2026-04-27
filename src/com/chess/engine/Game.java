package com.chess.engine;

import com.chess.model.*;

public class Game
{

    private Side currentTurn;
    private Board board;
    private boolean gameActive;

    public Game()
    {
        this.board = new Board();
        this.currentTurn = Side.WHITE;
        this.gameActive = true;
    }

    public boolean isGameActive()
    {
        return gameActive;
    }

    public boolean makeMove(Position from, Position to)
    {
        Piece movingPiece = board.getPiece(from);
        // 1. Basic Referee Checks
        if (movingPiece == null || movingPiece.getColor() != this.currentTurn)
        {
            return false;
        }

        // 2. Mathematical Check
        if (!movingPiece.isValidMove(from, to, board))
        {
            return false;
        }

        //3. Checking if the game will end
        if(board.getPiece(to) instanceof King)
        {
            this.gameActive = false;
            return true;
        }

        // 3. The Execution (The "Doer")
        this.board.executeMove(from, to);

        // 4. Switch turns
        this.currentTurn = (this.currentTurn == Side.WHITE) ? Side.BLACK : Side.WHITE;//switch turns
        return true;
    }

    public Piece getPiece(Position pos)
    {
        return this.board.getPiece(pos);
    }

    public Side getCurrentTurn()
    {
        return this.currentTurn;
    }


}
