package com.chess.model;

public class King extends Piece
{
    public King(Side color, Position position)
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

        if ((rowDif <= 1) && (colDif <= 1))
        {
            if (board.getPiece(to) == null || board.getPiece(to).getColor() != this.getColor())
            {
                return true;
            }
        }
        return false;
    }
}
