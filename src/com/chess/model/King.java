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

        // General move
        if ((rowDif <= 1) && (colDif <= 1))
        {
            if (board.getPiece(to) == null || board.getPiece(to).getColor() != this.getColor())
            {
                return true;
            }
        }

        //Castling
        if (rowDif == 0 && colDif == 2)
        {
            //---find direction---
            int rowStep = Integer.compare(to.getRow(), from.getRow());// Should be 0
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

            //Check if they have ever moved
            if(!this.hasMoved())
            {
                Piece rook;
                if(from.getRow() == 0 && colStep == 1)//Black King, right castling
                {
                    rook = board.getPiece(new Position(0, 7));
                }
                else if(from.getRow() == 0 && colStep == -1)//Black King, left castling
                {
                    rook = board.getPiece(new Position(0, 0));
                }
                else if(from.getRow() == 7 && colStep == 1)//White King, right castling
                {
                    rook = board.getPiece(new Position(7, 7));
                }
                else //White King, left castling, if(from.getRow() == 7 && colStep == -1)
                {
                    rook = board.getPiece(new Position(7, 0));
                }

                if (rook != null && !rook.hasMoved())
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
        return (this.color == Side.WHITE) ? "♔" : "♚";
    }
}
