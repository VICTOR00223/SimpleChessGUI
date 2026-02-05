public class Game
{

    private PlayerColor currentTurn;
    private Board board;

    public Game()
    {
        board = new Board();
        currentTurn = PlayerColor.WHITE;
    }

    private void switchTurn()
    {
        if(currentTurn == PlayerColor.WHITE)
        {
            currentTurn = PlayerColor.BLACK;
        }
        else
        {
            currentTurn = PlayerColor.WHITE;
        }
    }

    private boolean makeMove(Position from, Position to)
    {
        
    }

}
