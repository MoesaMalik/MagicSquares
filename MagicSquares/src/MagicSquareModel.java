import java.util.Arrays;

public class MagicSquareModel {
    private int[][] magicSquare;
    private int n; // Size of the magic square (n x n)
    private int totalSum; // The sum that all rows, columns, and diagonals should equal
    private int movesLeft;
    public MagicSquareModel(int n) {
        this.n = n;
        this.magicSquare = new int[n][n];
        this.totalSum = n * (n * n + 1) / 2; // Calculate the expected total sum
        this.movesLeft = n * n;
        // Initialize the magic square with zeros
        for (int i = 0; i < n; i++) {
            Arrays.fill(magicSquare[i], 0);
        }
    }

    public boolean isMagicSquare() {
        // Check if the magic square is valid
        int[] rowSums = new int[n];
        int[] colSums = new int[n];
        int mainDiagonalSum = 0;
        int antiDiagonalSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSums[i] += magicSquare[i][j];
                colSums[j] += magicSquare[i][j];

                if (i == j) {
                    mainDiagonalSum += magicSquare[i][j];
                }

                if (i + j == n - 1) {
                    antiDiagonalSum += magicSquare[i][j];
                }
            }
        }

        // Check if all row sums, column sums, and diagonals are equal to totalSum
        for (int i = 0; i < n; i++) {
            if (rowSums[i] != totalSum || colSums[i] != totalSum) {
                return false;
            }
        }

        return mainDiagonalSum == totalSum && antiDiagonalSum == totalSum;
    }

    public boolean isCellOccupied(int row, int col) {
        // Check if a cell in the magic square is occupied (contains a number)
        return magicSquare[row][col] != 0;
    }

    public void placeNumber(int row, int col, int number) {
        // Place a number in a cell of the magic square
        magicSquare[row][col] = number;
    }

    public int getN(){

        return n;
    }

    public boolean isWin() {
        // Check if the magic square is solved (win condition)
        if (movesLeft == 0 && isMagicSquare()) {
            return true;
        }
        return false;
    }

    public boolean isLoss() {
        // Check if the magic square is not solved (loss condition)
        if (movesLeft == 0 && !isMagicSquare()) {
            return true;
        }
        return false;
    }

    public void reduceMovesLeft(){
        if(movesLeft>0)
            movesLeft--;
    }
    // Other necessary methods
}

