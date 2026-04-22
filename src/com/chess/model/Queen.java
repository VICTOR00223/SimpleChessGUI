package com.chess.model;

public class Queen extends Piece
{
    public Queen(Side color, Position position)
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
        int rowDif = Math.abs(to.getRow()-from.getRow());
        int colDif = Math.abs(to.getCol()-from.getCol());

        if((rowDif == colDif) || (rowDif == 0) || (colDif == 0))
        {

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
        else
        {
            return false;
        }
    }

    @Override
    public String getIcon()
    {
        return (this.color == Side.WHITE) ? "♕" : "♛";
    }
}
