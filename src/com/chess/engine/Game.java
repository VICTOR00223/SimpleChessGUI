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

    public Piece getPiece(Position pos)
    {
        return this.board.getPiece(pos);
    }

    public Side getCurrentTurn()
    {
        return this.currentTurn;
    }

    public Side getOppositeTurn(){ return (this.currentTurn == Side.WHITE) ? Side.BLACK : Side.WHITE; }

    private boolean isKingUnderAttack(Position kingPos, Side attacker)
    {
        //This method will be inside the isMoveLegal and the isCheckmate method.
        //This method will be used to check if the King is unsafe
        //This method cannot run unless this.board.getPiece(targetPos) instanceof King
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                Position attackerPosition = new Position(i, j);
                Piece attackerPiece = this.board.getPiece(attackerPosition);
                if (attackerPiece != null && attackerPiece.getColor() == attacker)
                {
                    if (attackerPiece.isValidMove(attackerPosition, kingPos, this.board))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isMoveLegal(Position from, Position to)
    {
        Piece movingPiece = this.board.getPiece(from);

        //1. Check if the user actually pressed a piece.
        if (movingPiece == null)
        {
            return false;
        }

        //2. Check if it is his turn
        if (movingPiece.getColor() != this.currentTurn)
        {
            return false;
        }

        //3. Check if the rules of the piece allows this move.
        if (!movingPiece.isValidMove(from, to, board))
        {
            return false;
        }

        //4. Simulate the move
        Piece copyPiece = this.board.getPiece(to);// Copy the piece, so you don't lose it.
        this.board.setPiece(to, movingPiece);// Move the piece you choose.
        this.board.setPiece(from, null);// Clear the old spot.

        //5. Call the isKingUnderAttack method to check if my King is unsafe.
        boolean unsafe = this.isKingUnderAttack(this.board.findKing(this.currentTurn), this.getOppositeTurn());

        //6. Undo the move
        this.board.setPiece(from, movingPiece);
        this.board.setPiece(to, copyPiece);

        //7. Return the true if the king is safe, return false if the king is unsafe.
        return !unsafe;
    }

    public void MakeMove(Position from, Position to)
    {
        //1. The Execution (The "Doer")
        this.board.executeMove(from, to);

        //2. Check if pawn reached the end
        this.pawnToQueen(to);

        //3. Switch turns
        this.currentTurn = this.getOppositeTurn();

        //4. Check for Checkmate
        if (this.isCheckmate())
        {
            this.gameActive = false;
        }  
    }

    private boolean isCheckmate()
    {
        //1. Check if your King is under attack
        if(this.isKingUnderAttack(this.board.findKing(this.currentTurn), this.getOppositeTurn()))
        {
            //2. Check for all your pieces if they can protect your King (even the King)
            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 8; j++)
                {
                    //get the piece and it's position
                    Position defenderpos = new Position(i, j);
                    Piece defenderPiece = this.board.getPiece(defenderpos);

                    //3. Check if there is actually a piece and if there is, is it the same color
                    if (defenderPiece != null && defenderPiece.getColor() == this.currentTurn)
                    {
                        //4. Check all the squares the piece can go
                        for (int r = 0; r < 8; r++)
                        {
                            for (int c = 0; c < 8; c++)
                            {
                                Position protectionpos = new Position(r, c);

                                //5. Check if the move is legal. (A legal move must protect the King)
                                if (this.isMoveLegal(defenderpos, protectionpos))
                                {
                                    //If you can found a legal move you are not checkmate
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            //You lost
            return true;
        }
        //Your king is safe
        return false;
    }

    private void pawnToQueen(Position pos)
    {
        if(this.board.getPiece(pos) instanceof Pawn)
        {
            //if the white pawn is at row 0
            if(this.currentTurn == Side.WHITE && pos.getRow() == 0)
            {
                this.board.setPiece(pos, new Queen(Side.WHITE, pos));
            }

            //if the black pawn is at row 7
            if(this.currentTurn == Side.BLACK && pos.getRow() == 7)
            {
                this.board.setPiece(pos, new Queen(Side.BLACK, pos));
            }
        }
    }
}