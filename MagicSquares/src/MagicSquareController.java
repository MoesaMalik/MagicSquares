import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class MagicSquareController {
    private MagicSquareModel model;
    private MagicSquareView view;

    public MagicSquareController(int n) {
        model = new MagicSquareModel(n);
        view = new MagicSquareView(n);

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (e.getSource() == view.getButton(i, j)) {
                            handleButtonClick(i, j);
                            break;
                        }
                    }
                }
            }
        });
    }

    private void handleButtonClick(int row, int col) {
        if (!model.isCellOccupied(row, col)) {
            String input = JOptionPane.showInputDialog(view.getFrame(), "Enter a number:");
            try {
                int number = Integer.parseInt(input);
                if (number > 0 && number <= model.getN() * model.getN()) {
                    model.placeNumber(row, col, number);
                    view.setButtonText(row, col, String.valueOf(number));
                    model.reduceMovesLeft();

                    if (model.isWin()) {
                        view.displayMessage("Congratulations! You won the game!");
                    } else if (model.isLoss()) {
                        view.displayMessage("Sorry, you lost the game.");
                    }
                } else {
                    view.displayMessage("Please enter a valid number between 1 and " + model.getN() * model.getN());
                }
            } catch (NumberFormatException ex) {
                view.displayMessage("Please enter a valid number.");
            }
        } else {
            view.displayMessage("Cell is already occupied.");
        }
    }

    public static void main(String[] args) {
        int n = 3; // Change this to the desired size of the magic square (e.g., 5 for a 5x5 square)
        MagicSquareController controller = new MagicSquareController(n);
    }
}
