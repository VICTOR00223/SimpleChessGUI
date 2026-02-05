import javax.swing.*;
import java.awt.*;

public class testing3
{
    public static void main(String[] args)
    {
        //---------------Build window---------------
        JFrame frame = new JFrame("Simple Chess"); // open window
        frame.setSize(700, 600); // window size

        //---------------Draw chessboard---------------
        GridLayout layout = new GridLayout(8,8); // split window to 64 equal cells
        frame.setLayout(layout);
        JButton[][] squares = new JButton[8][8]; // creation of 2D array for JButton obj


        //---------------place starting pieces---------------
        char[][] board = {
                {'r','n','b','q','k','b','n','r'},
                {'p','p','p','p','p','p','p','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'P','P','P','P','P','P','P','P'},
                {'R','N','B','Q','K','B','N','R'}
        }; // starting positions


        for (int r = 0; r < 8; r++)
        {
            for (int c = 0; c < 8; c++)
            {
                JButton btn = new JButton(); // Create obj
                if((r+c)%2 == 0)
                {
                    btn.setBackground(Color.WHITE);
                }
                else
                {
                    btn.setBackground(Color.GRAY);
                }
                squares[r][c] = btn;  // fill array
                frame.add(squares[r][c]); // Assign obj to each cell

                switch (board[r][c]) // Give each row and column the right piece
                {
                    case 'P': btn.setText("♙"); break;
                    case 'p': btn.setText("♟"); break;
                    case 'K': btn.setText("♔"); break;
                    case 'k': btn.setText("♚"); break;
                    case 'Q': btn.setText("♕"); break;
                    case 'q': btn.setText("♛"); break;
                    case 'R': btn.setText("♖"); break;
                    case 'r': btn.setText("♜"); break;
                    case 'B': btn.setText("♗"); break;
                    case 'b': btn.setText("♝"); break;
                    case 'N': btn.setText("♘"); break;
                    case 'n': btn.setText("♞"); break;
                    case '.': btn.setText(" "); break;
                }
                btn.setFont(new Font("SansSerif", Font.PLAIN, 36)); // Make the pieces bigger
            }
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close window with x
        frame.setVisible(true); //make the window visible
    }


    //---------------Rules---------------


}