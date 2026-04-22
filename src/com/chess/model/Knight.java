package com.chess.model;

public class Knight extends Piece
{
    public Knight(Side color, Position position)
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

        if(rowDif * colDif == 2)
        {
            if(board.getPiece(to) == null || board.getPiece(to).getColor() != this.getColor())
            {
                return true;
            }
        }
        return false;
    }
    @Override
    public String getIcon()
    {
        return (this.color == Side.WHITE) ? "♘" : "♞";
    }
}
