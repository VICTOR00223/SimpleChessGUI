import javax.swing.*;
import java.awt.*;

public class testing4
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Simple Chess"); // open window
        frame.setSize(700, 600); // window size
        GridLayout layout = new GridLayout(2,1); // split window to 2 equal cells
        frame.setLayout(layout);
        JButton[][] squares = new JButton[2][1];

        char[][] board = {{'.'}, {'k'}};

        for(int i=0; i<2; i++)
        {
            JButton btn = new JButton(); // Create obj
            squares[i][0] = btn;// fill array
            frame.add(squares[i][0]); // Assign obj to each cell
            if (i==0)
            {
                btn.setText("♚");
            }
            else
            {
                btn.setText(" ");
            }
            btn.setFont(new Font("SansSerif", Font.PLAIN, 36)); // Make the pieces bigger
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close window with x
        frame.setVisible(true); //make the window visible
    }
}
