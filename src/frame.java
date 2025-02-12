import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame {
    public static void main(String[] args) {
        
        // Create the frame
        JFrame frame = new JFrame("User Form");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        
        // Create labels
        JLabel l1 = new JLabel("Digits:");
        JTextField t1 = new JTextField(10);
        JLabel l2 = new JLabel("Username:");
        JTextField t2 = new JTextField(10);
        
        // Create button
        JButton submitButton = new JButton("+");
        
        // Add action listener to button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String digits = t1.getText();
                int a =Integer.parseInt(digits);
                String username = t2.getText();
                int b =Integer.parseInt(username);
                JOptionPane.showMessageDialog(frame, a+b);
            }
        });
        
        JButton submitButton1 = new JButton("-");
        
        // Add action listener to button
        submitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String digits = t1.getText();
                int a =Integer.parseInt(digits);
                String username = t2.getText();
                int b =Integer.parseInt(username);
                JOptionPane.showMessageDialog(frame, a-b);
            }
        });
        
        frame.add(l1);
        frame.add(t1);       // Add components to frame
        frame.add(l2);
        frame.add(t2);
        frame.add(submitButton);
        frame.add(submitButton1);
        
        frame.setVisible(true);
    }
}

