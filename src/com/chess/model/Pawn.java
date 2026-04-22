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
        if(from.equals(to))
        {
            return false;
        }

        // White moves up (-1), Black moves down (+1)
        // Starting row for double-move
        int direction;
        int startRow;
        if(this.getColor() == Side.WHITE)
        {
            direction = -1;
            startRow = 6;
        }
        else
        {
            direction = 1;
            startRow = 1;
        }

        if(board.getPiece(to) == null)
        {
            //---One Forward---
            if(to.getCol() == from.getCol() && to.getRow() == from.getRow() + direction)
            {
                return true;
            }
            //---Two Forward---
            if(to.getCol() == from.getCol() && to.getRow() == from.getRow() + 2*direction && from.getRow() == startRow)
            {
                Position oneforward = new Position(from.getRow() + direction, from.getCol());
                if(board.getPiece(oneforward) == null)
                {
                    return true;
                }
            }
        }
        else
        {
            //---Capture---
            int colDif = Math.abs(from.getCol() - to.getCol());
            if(to.getRow() == from.getRow()+direction && colDif == 1)
            {
                if(this.getColor() != board.getPiece(to).getColor())
                {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getIcon()
    {
        return (this.color == Side.WHITE) ? "♙" : "♟";
    }
}