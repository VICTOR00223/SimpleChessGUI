public class Knight extends Piece
{
    public Knight(PlayerColor color, Position position)
    {
        super(color, position);
    }


    @Override
    public boolean isValidMove(Position from, Position to, Board board)
    {
        int rowDif = Math.abs(to.getRow()-from.getRow());
        int colDif = Math.abs(to.getCol()-from.getCol());

        if(Math.abs(rowDif-colDif) == 1)
        {
            if(board.getPiece(to.getRow(), to.getCol()) == null || board.getPiece(to.getRow(), to.getCol()).getColor() != getColor())
            {
                return true;
            }
        }
        return false;
    }
}
