import java.io.FileNotFoundException;

public class SudokuValidator {

    public static int[][] sudoku = {
            {1, 2, 4, 5, 3, 9, 1, 8, 7},
            {5, 1, 9, 7, 2, 8, 6, 3, 4},
            {8, 3, 7, 6, 1, 4, 2, 9, 5},
            {1, 4, 3, 8, 6, 5, 7, 2, 9},
            {9, 5, 8, 2, 4, 7, 3, 6, 1},
            {7, 6, 2, 3, 9, 1, 4, 5, 8},
            {3, 7, 1, 9, 5, 6, 8, 4, 2},
            {4, 9, 6, 1, 8, 2, 5, 7, 3},
            {2, 8, 5, 4, 7, 3, 9, 1, 6}
    };

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        sudoku = new CsvImporter().run();

        RowValidator rowValidator = new RowValidator(0, 0);
        ColumnValidator columnValidator = new ColumnValidator(0, 0);
        GridValidator gridValidator = new GridValidator();
        new Thread(rowValidator).start();
        new Thread(columnValidator).start();
        new Thread(gridValidator).start();

        Thread.sleep(5000);
    }

    public int[][] getSudoku() {
        return sudoku;
    }
}
