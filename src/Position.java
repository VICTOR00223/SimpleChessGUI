public class Position
{
    //Oi syntetagmenes tou kathe piece
    private int row;
    private int col;

    public Position(int r, int c)
    {
        row = r;
        col = c;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public String toNotation()
    {
        String letter;
        switch (col)
        {
            case 0:
            {
                letter = "a";
                break;
            }
            case 1:
            {
                letter = "b";
                break;
            }
            case 2:
            {
                letter = "c";
                break;
            }
            case 3:
            {
                letter = "d";
                break;
            }
            case 4:
            {
                letter = "e";
                break;
            }
            case 5:
            {
                letter = "f";
                break;
            }
            case 6:
            {
                letter = "g";
                break;
            }
            case 7:
            {
                letter = "h";
                break;
            }
            default:
            {
                return "?";
            }
        }
        return letter + (8-row);
    }
}
