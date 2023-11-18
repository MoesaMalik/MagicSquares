import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MagicSquareView {
    private JFrame frame;
    private JButton[][] buttons;
    private int n;

    public MagicSquareView(int n) {
        this.n = n;
        frame = new JFrame("Magic Square Puzzle");
        frame.setLayout(new GridLayout(n, n));
        buttons = new JButton[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                buttons[i][j] = new JButton("");
                frame.add(buttons[i][j]);
            }
        }

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void addActionListener(ActionListener listener) {
        // Add action listeners to the buttons for user interactions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                buttons[i][j].addActionListener(listener);
            }
        }
    }

    public void displayMessage(String message) {
        // Display a message to the user using JOptionPane or a similar mechanism
        JOptionPane.showMessageDialog(frame, message);
    }

    // Other necessary methods for updating the view
    public void setButtonText(int row, int col, String text) {
        buttons[row][col].setText(text);
    }

    public JButton getButton(int row, int col) {
        // Get a button from the view
        return buttons[row][col];
    }

    public JFrame getFrame() {
        return frame;
    }
}
