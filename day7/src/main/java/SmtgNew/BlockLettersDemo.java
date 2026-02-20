package SmtgNew;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BlockLettersDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Letter Blocker");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTextField textField = new JTextField(20);

            // KeyListener to intercept and block letters
            textField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Check if the character is a letter (a-z or A-Z)
                    if (Character.isLetter(c)) {
                        e.consume(); // Ignore the event, block input
                    }
                }
            });

            frame.add(new JLabel("Type numbers only: "), "North");
            frame.add(textField, "Center");
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

