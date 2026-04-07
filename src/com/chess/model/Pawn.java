package com.chess.model;

public class Pawn extends Piece
{
    public Pawn(Side color, Position position)
    {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position from, Position to, Board board)
    {
        // White moves up (-1), Black moves down (+1)
        // Starting row for double-move
        int direction;
        int startRow;
        if(getColor() == Side.WHITE)
        {
            direction = -1;
            startRow = 6;
        }
        else
        {
            direction = 1;
            startRow = 1;
        }

        //---One Forward---
        if(to.getCol() == from.getCol() && to.getRow() == from.getRow() + direction)
        {
            if(board.getPiece(to.getRow(), to.getCol()) == null)
            {
                return true;
            }
        }

        //---Two Forward---
        if(to.getCol() == from.getCol() && to.getRow() == from.getRow() + 2*direction && from.getRow() == startRow)
        {
            if(board.getPiece(from.getRow()+direction, from.getCol()) == null && board.getPiece(to.getRow(), to.getCol()) == null)
            {
                return true;
            }
        }

        //---Capture---
        if(board.getPiece(to.getRow(), to.getCol()) != null)
        {
            if(to.getRow() == from.getRow()+direction && (to.getCol() == from.getCol() + 1 || to.getCol() == from.getCol() - 1))
            {
                if(board.getPiece(to.getRow(), to.getCol()).getColor() != getColor())
                {
                    return true;
                }
            }
        }
        return false;
    }
}