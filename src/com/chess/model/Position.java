package com.chess.model;

public class Position
{
    //Oi syntetagmenes tou kathe piece
    private final int row;
    private final int col;

    public Position(int r, int c)
    {
        if (!isValid(r, c))
        {
            throw new IllegalArgumentException("Out of bounds!");
        }
        this.row = r;
        this.col = c;
    }

    public static boolean isValid(int r, int c)
    {
        return r >= 0 && r < 8 && c >= 0 && c < 8;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


    @Override
    public boolean equals(Object obj)
    {
        // 1. Identity check
        if (this == obj) return true;

        // 2. Type and Null check
        if (!(obj instanceof Position)) return false;

        // 3. Data check (Cast 'obj' to a Position so we can see its rows/cols)
        Position other = (Position) obj;
        return this.row == other.row && this.col == other.col;
    }

    @Override
    public int hashCode()
    {
        return java.util.Objects.hash(row, col);
    }

//        public String toNotation()
//    {
//        String letter;
//        switch (col)
//        {
//            case 0:
//            {
//                letter = "a";
//                break;
//            }
//            case 1:
//            {
//                letter = "b";
//                break;
//            }
//            case 2:
//            {
//                letter = "c";
//                break;
//            }
//            case 3:
//            {
//                letter = "d";
//                break;
//            }
//            case 4:
//            {
//                letter = "e";
//                break;
//            }
//            case 5:
//            {
//                letter = "f";
//                break;
//            }
//            case 6:
//            {
//                letter = "g";
//                break;
//            }
//            case 7:
//            {
//                letter = "h";
//                break;
//            }
//            default:
//            {
//                return "?";
//            }
//        }
//        return letter + (8-row);
//    }
}
