import javax.swing.*;        // for JFrame, JButton
import java.awt.event.*;

public class testing2
{
    public static void main(String[] args) {
        // Create a window
        JFrame frame = new JFrame("Button Example");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Create a button
        JButton button = new JButton("Press me");

        // Add an action listener to the button
        class MyHandler implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Clicked!");
            }
        }
        MyHandler myHandler = new MyHandler();
        
        button.addActionListener(myHandler);
        // Add button to frame
        frame.add(button);
        // Show window
        frame.setVisible(true);
    }
}
