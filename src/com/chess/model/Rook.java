package com.chess.model;

public class Rook extends Piece
{
    public Rook(Side color, Position position)
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
        if (from.getRow() != to.getRow() && from.getCol() != to.getCol())
        {
            return false;
        }

        /*
        Integer.compare(a, b)
        condition
            a<b  return -1
            a==b return 0
            a>b  return 1
         */

        //---find direction---
        int rowStep = Integer.compare(to.getRow(), from.getRow());
        int colStep = Integer.compare(to.getCol(), from.getCol());

        int r = from.getRow() + rowStep;
        int c = from.getCol() + colStep;

        //---Check if squares are empty---
        while (r != to.getRow() || c != to.getCol())
        {
            Position now = new Position(r, c);
            if (board.getPiece(now) != null)
            {
                return false;
            }
            r += rowStep;
            c += colStep;
        }

        //---Check if target square is empty or capture---
        if(board.getPiece(to) == null || board.getPiece(to).getColor() != this.getColor())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}


