package com.chess.model;

import static com.chess.model.Position.isValid;

public class Board
{

    //should be private because other classes have no job interfering with it
    private static final char[][] START_LAYOUT = {
            {'r','n','b','q','k','b','n','r'},
            {'p','p','p','p','p','p','p','p'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'P','P','P','P','P','P','P','P'},
            {'R','N','B','Q','K','B','N','R'}
    }; // starting positions

    private Piece[][] grid = new Piece[8][8];


    public Board()
    {
        initializeFromLayout();
    }

    private void initializeFromLayout()
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                char c = START_LAYOUT[i][j];
                Position pos = new Position(i, j);

                if(c != '.')
                {
                    Side color;
                    if(Character.isUpperCase(c))
                    {
                        color = Side.WHITE;
                    }
                    else
                    {
                        color = Side.BLACK;
                    }
                    char pieceChar = Character.toLowerCase(c);

                    switch (pieceChar)
                    {
                        case 'p':
                            this.grid[i][j] = new Pawn(color, pos);
                            break;
                        case 'r':
                            this.grid[i][j] = new Rook(color, pos);
                            break;
                        case 'n':
                            this.grid[i][j] = new Knight(color, pos);
                            break;
                        case 'b':
                            this.grid[i][j] = new Bishop(color, pos);
                            break;
                        case 'q':
                            this.grid[i][j] = new Queen(color, pos);
                            break;
                        case 'k':
                            this.grid[i][j] = new King(color, pos);
                            break;
                    }
                }
            }
        }
    }



    public Piece getPiece(Position pos)
    {
        return this.grid[pos.getRow()][pos.getCol()];
    }

    public void setPiece(Position pos, Piece piece)
    {
        this.grid[pos.getRow()][pos.getCol()] = piece;
    }

    public void executeMove(Position from, Position to)
    {
        // 1. Move the piece to the new spot in the grid
        setPiece(to, this.getPiece(from));

        // 2. Clear the old spot
        setPiece(from, null);

        // This ensures piece.getPosition() stays in sync with the board grid
        if (this.getPiece(to) != null)
        {
            this.getPiece(to).setPosition(to);
        }
    }
}

