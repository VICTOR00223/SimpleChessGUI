public class Board
{
    //should be private because other classes have no job interfering with it
    private final char[][] start = {
            {'r','n','b','q','k','b','n','r'},
            {'p','p','p','p','p','p','p','p'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'P','P','P','P','P','P','P','P'},
            {'R','N','B','Q','K','B','N','R'}
    }; // starting positions

    private Piece[][] board = new Piece[8][8];


    public Board()
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                char c = start[i][j];
                Position pos = new Position(i, j);

                if(c == '.')
                {
                    board[i][j] = null;
                }
                else
                {
                    PlayerColor color;
                    if (Character.isUpperCase(c))
                    {
                        color = PlayerColor.WHITE;
                    }
                    else
                    {
                        color = PlayerColor.BLACK;
                    }

                    char pieceChar = Character.toLowerCase(c);

                    switch (pieceChar)
                    {
                        case 'p':
                            board[i][j] = new Pawn(color, pos);
                            break;
                        case 'r':
                            board[i][j] = new Rook(color, pos);
                            break;
                        case 'n':
                            board[i][j] = new Knight(color, pos);
                            break;
                        case 'b':
                            board[i][j] = new Bishop(color, pos);
                            break;
                        case 'q':
                            board[i][j] = new Queen(color, pos);
                            break;
                        case 'k':
                            board[i][j] = new King(color, pos);
                            break;
                    }
                }
            }
        }
    }

    public Piece getPiece(int r, int c)
    {
        return board[r][c];
    }
}
