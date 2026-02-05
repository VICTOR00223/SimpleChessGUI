public abstract class Piece
{
    private PlayerColor color;
    private Position position;

    public Piece(PlayerColor color, Position position)
    {
        this.color = color;
        this.position = position;
    }

    public void setPosition(Position newposition)
    {
        this.position = newposition;
    }

    public PlayerColor getColor()
    {
        return color;
    }

    public Position getPosition()
    {
        return position;
    }

    public abstract boolean isValidMove(Position from, Position to, Board board);
}
