public class Queen extends Piece
{
    public Queen(PlayerColor color, Position position)
    {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position from, Position to, Board board)
    {
        int rowDif = Math.abs(to.getRow()-from.getRow());
        int colDif = Math.abs(to.getCol()-from.getCol());

        if((rowDif == colDif) || (rowDif == 0) || (colDif == 0))
        {
            //Bishop and Rook move

            //---find direction---
            int rowStep = Integer.compare(to.getRow(), from.getRow());
            int colStep = Integer.compare(to.getCol(), from.getCol());

            int r = from.getRow() + rowStep;
            int c = from.getCol() + colStep;

            //---Check if squares are empty---
            while (r != to.getRow() || c != to.getCol())
            {
                if (board.getPiece(r, c) != null)
                {
                    return false;
                }
                r += rowStep;
                c += colStep;
            }

            //---Check if target square is empty or capture---
            if(board.getPiece(to.getRow(), to.getCol()) == null || board.getPiece(to.getRow(), to.getCol()).getColor() != getColor())
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
}
