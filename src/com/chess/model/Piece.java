package com.chess.model;

public abstract class Piece
{
    protected final Side color;
    protected Position position;

    public Piece(Side color, Position position)
    {
        this.color = color;
        this.position = position;
    }

    public void setPosition(Position newposition)
    {
        this.position = newposition;
    }

    public Side getColor()
    {
        return this.color;
    }

    public Position getPosition()
    {
        return this.position;
    }

    public boolean isCaptured()
    {
        return this.position == null;
    }

    public abstract boolean isValidMove(Position from, Position to, Board board);
}
