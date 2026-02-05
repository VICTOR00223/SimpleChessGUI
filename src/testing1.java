import javax.swing.*;
import java.awt.*;

public class testing1
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Hello"); // works, JFrame is imported
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(8,8));
        JLabel label = new JLabel("Hello", SwingConstants.CENTER);

        // Add the label to the frame
        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
/* This program tests how JFrame class work, from which package we extract it, why it is useful, how Jlabel class work, why it is useful.*/